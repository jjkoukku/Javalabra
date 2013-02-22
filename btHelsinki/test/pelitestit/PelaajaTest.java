package pelitestit;

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
// ei paljoa testattavaaa
public class PelaajaTest {
    
    public PelaajaTest() {
    }    
        @Test
    public void testiNimelle() {
     String nimi = "kekkonen";       
     Pelaaja kekkonen = new Pelaaja(nimi, Color.RED);
     assertEquals(kekkonen.toString(),nimi);
  }
}
