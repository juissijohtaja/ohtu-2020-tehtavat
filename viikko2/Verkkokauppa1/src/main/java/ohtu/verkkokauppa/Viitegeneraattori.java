package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements ViitegeneraattoriApi {

//    private static Viitegeneraattori instanssi;
//
//    public static Viitegeneraattori getInstance() {
//        if (instanssi == null) {
//            instanssi = new Viitegeneraattori();
//        }
//
//        return instanssi;
//    }
    
    private int seuraava;
    
    @Autowired
    public Viitegeneraattori(){
        seuraava = 1;
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
