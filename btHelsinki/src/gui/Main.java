package gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.SwingUtilities;
import bthelsinki.*;
import java.awt.Color;

/**
 *
 * @author jjkoukku
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelilauta pelilauta = new Pelilauta(3,3);        
        Pelaaja pelaaja1 = new Pelaaja("S",Color.BLUE);
        Pelaaja pelaaja2 = new Pelaaja("P", Color.RED);        
        Peli peli = new Peli(pelilauta,pelaaja1, pelaaja2);
        PaaIkkuna paaikkuna = new PaaIkkuna(peli);
        SwingUtilities.invokeLater(paaikkuna);

      
    }
}

