
package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class PeliOperaatio {
    private static final Scanner scanner = new Scanner(System.in);
    public int siirto;
    public String ekanSiirto;
    public String tokanSiirto;

    public PeliOperaatio() {
        siirto = 0;
    }

    public void pelaa() {
        
        Tuomari tuomari = new Tuomari();
        boolean jatkaPelia = true;

        while (jatkaPelia) {
            
            System.out.println("Anna siirto\n"
                    + "k: kivi | p: paperi | s: sakset | muu: lopeta");

            ekanSiirto = scanner.nextLine();

            tokanSiirto = this.annaSiirto();
            System.out.println("Vastustaja valitsi: " + tokanSiirto);
            this.asetaSiirto(ekanSiirto);
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            
            jatkaPelia = (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto));
        }

        System.out.println("\nKiitos!\n");
        System.out.println(tuomari);
        

    }
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract String annaSiirto();
    protected abstract void asetaSiirto(String siirto);
 
}
