/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

import txtUI.TxtUI;

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
        
        Pelaaja pelaaja1 = new Pelaaja("S");
        Pelaaja pelaaja2 = new Pelaaja("P");
        TxtUI gui = new TxtUI();
        Peli peli = new Peli(pelilauta, gui, pelaaja1, pelaaja2);
        peli.aloita();
        
 
        
    }
}
