package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class KauppaTest {
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        k = new Kauppa(varasto, pankki, viite);
        
        // määritellään viitenumeroksi 42
        when(viite.uusi()).thenReturn(42);
        
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        // määritellään että tuote numero 2 on juusto jonka hinta on 10 ja saldo 5
        when(varasto.saldo(2)).thenReturn(5); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "juusto", 10));
        
        // määritellään että tuote numero 3 on kahvi jonka hinta on 20 ja saldo 0
        when(varasto.saldo(3)).thenReturn(0); 
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "kahvi", 20));
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        
        // tehdään ostokset
        k.aloitaAsiointi();
        
        // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);
        
        // suoritetaan maksu
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
    
    @Test
    public void yhdenTuotteenOstoOnnistuu() {

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));   
    }
    
    @Test
    public void kahdenEriTuotteenOstoOnnistuu() {
        
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli juustoa
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(15));    
        
    }
    
    @Test
    public void kahdenSamanTuotteenOstoOnnistuu() {

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10));  
    }
    
    @Test
    public void kahdenEriTuotteenOstoEiOnnistuJosToinenTuoteLoppu() {

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(3);     // ostetaan tuotetta numero 3 eli kahvia, saldo 0
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));  
    }
    
    
    @Test
    public void koriTyhjeneeKunKaksiEriOstoa() {

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        
        // tehdään toiset ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        // varmistetaan, että pankin metodia tilisiirto on kutsuttu oikealla summalla
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), eq(20));   
        
    }
    
    
    @Test
    public void kauppaPyytaaUudenViitenumeronJokaiseenMaksuun() {
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        // varmistetaan, että viitettä on pydetty kahdesti
        verify(viite, times(2)).uusi();

    }
    
    @Test
    public void poistaKoristaToimii() {

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.poistaKorista(2);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));  
    }
}