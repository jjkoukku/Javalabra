/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import bthelsinki.*;
import java.awt.Color;
/**
 *
 * @author jjkoukku
 */
public class PelilautaTest {
    
    Pelilauta pelilauta;
    int leveys=10;
    int korkeus=20;
    int midL= leveys/2;
    int midK = korkeus/2;
    
    Pelaaja testiMies = new Pelaaja("Kekkonen", Color.BLUE);
    
    public PelilautaTest() {
    }
    
    @Before
    public void setUp() {
        pelilauta = new Pelilauta(leveys,korkeus);
        pelilauta.getRuutu(midL, midK).setOmistaja(testiMies);
    }
    
    @Test
     public void tyhjaRuutu() {
         assertEquals(pelilauta.getRuutu(1, 1).toString(),"<< 0,h,true >>");
     }
    @Test
    public void ulkoRuutuLiianSuurilla() {
         assertEquals(pelilauta.getRuutu(leveys+1, korkeus+1).toString(),"<< 0,h,false >>");
     }
    
    @Test
    public void ulkoRuutuLiianPienillä() {
         assertEquals(pelilauta.getRuutu(0, 0).toString(),"<< 0,h,false >>");
     }
    
    @Test
    public void OmistajaOikein() {
         
        assertEquals(pelilauta.getRuutu(midL, midK).toString(),"<< 0,"+testiMies.toString()+",true >>");
     }
    
    @Test
    public void YksikotOikein() {
        pelilauta.getRuutu(midL, midK).setYksikot(10);
        assertEquals(pelilauta.getRuutu(midL, midK).toString(),"<< 10,"+testiMies.toString()+",true >>");
     }
    

    
}
