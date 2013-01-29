/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bthelsinki.Pelaaja;
import bthelsinki.Peli;
import bthelsinki.Pelilauta;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import txtUI.TxtUI;

/**
 *
 * @author jjkoukku
 */
public class PeliTest {
    Peli peli;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    public PeliTest() {
    }
    
    @Before
    public void setUpClass() {
        Pelilauta pelilauta = new Pelilauta(3,3);        
        pelaaja1 = new Pelaaja("S",Color.BLUE);
        pelaaja2 = new Pelaaja("P", Color.RED);        
        peli = new Peli(pelilauta,pelaaja1, pelaaja2);
    }
    
    @Test
    public void vuoroAlussaOikein(){
        assertEquals(peli.getvuorossaOleva().toString(),pelaaja1.toString());
    }
    
    @Test
    public void vuoroSiirtyyOikein(){
        peli.lopetaVuoro();
        assertEquals(peli.getvuorossaOleva().toString(),pelaaja2.toString());
    }
    
    public void vuoroSiirtyyOikeinTakaisin(){
        peli.lopetaVuoro();
        peli.lopetaVuoro();
        assertEquals(peli.getvuorossaOleva().toString(),pelaaja1.toString());
    }
}
