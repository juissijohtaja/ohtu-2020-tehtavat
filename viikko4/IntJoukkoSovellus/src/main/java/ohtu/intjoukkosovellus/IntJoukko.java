
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuJoukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int indeksi;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this.indeksi = 0;
        this.lukuJoukko = new int[KAPASITEETTI];
        this.kasvatusKoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        this.indeksi = 0;
        if (kapasiteetti < 0) {
            return;
        }
        this.lukuJoukko = new int[kapasiteetti];
        this.kasvatusKoko = OLETUSKASVATUS;

    }    
    
    public IntJoukko(int kapasiteetti, int kasvatusKoko) {
        this.indeksi = 0;
        if (kapasiteetti < 0 || kasvatusKoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti tai kasvatusKoko väärin");
        }
        this.lukuJoukko = new int[kapasiteetti];
        this.kasvatusKoko = kasvatusKoko;
    }

    public boolean lisaa(int luku) {
        
        if (!kuuluu(luku)) {
            lukuJoukko[indeksi] = luku;
            indeksi++;
            if (indeksi == lukuJoukko.length) {
                kasvataTaulukko();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        return luvunIndeksi(luku) > -1;
    }
    
    private int luvunIndeksi(int luku) {
        for (int i = 0; i < indeksi; i++) {
            if (luku == lukuJoukko[i]) {
                return i;
            }
        }
        return -1; // lukua ei löydy
    }

    public boolean poista(int luku) {
        int poistoIndeksi = luvunIndeksi(luku); 
        
        if (poistoIndeksi > -1) {
            lukuJoukko[poistoIndeksi] = 0;
            siirraLuvut(poistoIndeksi);
            
            indeksi--;
            return true;
        }
        return false;
    }
    
    private void siirraLuvut(int poistoIndeksi) {
        int apu;
        for (int j = poistoIndeksi; j < indeksi - 1; j++) {
            apu = lukuJoukko[j];
            lukuJoukko[j] = lukuJoukko[j + 1];
            lukuJoukko[j + 1] = apu;
        }
    }

    private void kasvataTaulukko() {
        int[] lukuJoukkoUusi = new int[indeksi + kasvatusKoko];
        for (int i = 0; i < lukuJoukko.length; i++) {
            lukuJoukkoUusi[i] = lukuJoukko[i];
        }
        lukuJoukko = lukuJoukkoUusi;
    }

    public int mahtavuus() {
        return indeksi;
    }


    @Override
    public String toString() {
        if (indeksi == 0) {
            return "{}";
        } else {
            StringBuilder tuloste = new StringBuilder("{");
            for (int i = 0; i < indeksi; i++) {
                if (i>0) {
                    tuloste.append(", ");
                }
                tuloste.append(lukuJoukko[i]);
            }
            tuloste.append("}");
            return tuloste.toString(); 
        }
    }

    public int[] toIntArray() {
        return Arrays.copyOf(lukuJoukko, indeksi);
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (!b.kuuluu(aTaulu[i])) {
                b.lisaa(aTaulu[i]);
            }
        }
        return b;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (!b.kuuluu(aTaulu[i])) {
                a.poista(aTaulu[i]);
            }
        }
        return a;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i])) {
                a.poista(aTaulu[i]);
            }
        }
        return a;
    }
        
}
