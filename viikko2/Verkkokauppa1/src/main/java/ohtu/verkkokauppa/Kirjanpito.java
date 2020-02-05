
package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kirjanpito implements KirjanpitoApi {
//    private static Kirjanpito instance;
//    
//    public static Kirjanpito getInstance() {
//        if ( instance==null) {
//            instance = new Kirjanpito();
//        }
//        
//        return instance;
//    }
    
    private ArrayList<String> tapahtumat;
    
    @Autowired
    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
