/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

import java.awt.Color;
import txtUI.TxtUI;

/**
 *
 * @author jjkoukku
 */
public class btHelsinki {

    /** Enää vain leikkimistä varten olemassaoleva main-metodi
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelilauta pelilauta = new Pelilauta(3,3);        
        Pelaaja pelaaja1 = new Pelaaja("S", Color.BLUE);
        Pelaaja pelaaja2 = new Pelaaja("P", Color.RED);        
        Peli peli = new Peli(pelilauta,pelaaja1, pelaaja2);
        TxtUI ui = new TxtUI(peli);
        ui.aloita();
      
    }
}
