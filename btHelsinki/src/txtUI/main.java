/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtUI;

import bthelsinki.Pelaaja;
import bthelsinki.Peli;
import bthelsinki.Pelilauta;
import java.awt.Color;

/**
 *
 * @author joonas
 */
public class main {
    
    public static void main(String[] args) {
        Pelilauta pelilauta = new Pelilauta(3,3);        
        Pelaaja pelaaja1 = new Pelaaja("S", Color.BLUE);
        Pelaaja pelaaja2 = new Pelaaja("P", Color.RED);        
        Peli peli = new Peli(pelilauta,pelaaja1, pelaaja2);
        TxtUI g = new TxtUI(peli);
        int[] testitaulu = g.askKoordinaatit();
        int testimaara = g.askMaara();
        System.out.println("");
        System.out.println("**********");
        System.out.println("**********");
   
        System.out.println(testitaulu[0] + ", " + testitaulu[1]);
        System.out.println(testimaara);
    }  
}
