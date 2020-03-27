
package ohtu.kivipaperisakset;

public class PeliTuntematon extends PeliOperaatio {
    
    public PeliTuntematon() {
        super();
    }

    @Override
    public void pelaa() {
        System.out.println("Kiitos ja näkemiin.");
        System.exit(0);
    }

    @Override
    protected String annaSiirto() {
        return "";
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
        // no action required;
    }
    
}
