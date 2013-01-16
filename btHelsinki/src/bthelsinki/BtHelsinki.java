/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

/**
 *
 * @author jjkoukku
 */
public class BtHelsinki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Peli peli = new Peli(3,3);
        peli.setPelaaja1(new Pelaaja("Jaska", false));
        peli.setPelaaja1(new Pelaaja("Marko", true));
        peli.tulostaRuudukko();
    }
}
