
package ohtu.kivipaperisakset;

public class PeliTekoaly extends PeliOperaatio {

    public PeliTekoaly() {
        super();
    }

    @Override
    protected String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
        // no action required;
    }
    
}
