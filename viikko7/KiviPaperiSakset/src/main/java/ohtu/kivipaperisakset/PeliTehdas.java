
package ohtu.kivipaperisakset;

import java.util.HashMap;

public class PeliTehdas {
    
    private HashMap<String, PeliOperaatio> komennot;
    private PeliOperaatio tuntematon;

    public PeliTehdas() {
        komennot = new HashMap<String, PeliOperaatio>();
        komennot.put("a", new PeliVersus());
        komennot.put("b", new PeliTekoaly());
        komennot.put("c", new PeliTekoalyPro(20));
        tuntematon = new PeliTuntematon();
    }

    public PeliOperaatio hae(String operaatio) {
        return komennot.getOrDefault(operaatio, tuntematon);
    }
}
