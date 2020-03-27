
package ohtu.kivipaperisakset;

import java.util.Scanner;

public class PeliVersus extends PeliOperaatio {
    
    private Scanner komento;

    public PeliVersus() {
        super();
        komento = new Scanner(System.in);
    }

    @Override
    protected String annaSiirto() {
        return komento.nextLine();
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
        // no action required;
    }
    
}
