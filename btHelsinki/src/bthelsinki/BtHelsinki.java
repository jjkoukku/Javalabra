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
        Pelilauta pelilauta = new Pelilauta(3,3);
        
        Pelaaja pelaaja1 = new Pelaaja("sininen");
        Pelaaja pelaaja2 = new Pelaaja("punainen");
        
        Peli peli = new Peli(pelilauta, pelaaja1, pelaaja2);
        
        
        pelilauta.tulostaRuudukko();
        
    }
}
