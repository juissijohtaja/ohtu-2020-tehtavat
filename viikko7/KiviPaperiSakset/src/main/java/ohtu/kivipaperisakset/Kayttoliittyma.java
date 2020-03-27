
package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Kayttoliittyma {
    private static Scanner scanner;
    private PeliTehdas komennot;

    public Kayttoliittyma() {
        this.scanner = new Scanner(System.in);
        this.komennot = new PeliTehdas();
    }
    
    public void kaynnista() {
        boolean jatkaPelia = true;
        
        while (jatkaPelia) {
            System.out.println("\nValitse vastustaja"
                    + "\na: ihminen | b: tekoäly | c: parannettu tekoäly | muu: lopeta");

            String vastaus = scanner.nextLine();
            komennot.hae(vastaus).pelaa(); 
        }
    }
}
    