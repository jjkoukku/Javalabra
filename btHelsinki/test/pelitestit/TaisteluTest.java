package pelitestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bthelsinki.Taistelu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jjkoukku
 */
public class TaisteluTest {
    
    public TaisteluTest() {
    }
    @Test
    public void nollaEiaiheutaTuhoa() {
     int[] testi = Taistelu.taistele(1000, 0);
     assertEquals(testi[0],1000);
  }
    
    @Test
    public void puolustajaVoittaaPitkassaJuoksussa() {
     int puolustusjoukot=0;
     int hyokkaysjoukot=0;
        for (int i = 0; i < 1000; i++) {                   
     int[] testi = Taistelu.taistele(100, 100);    
        puolustusjoukot += testi[1];
        hyokkaysjoukot  += testi[0];
        }
    assertEquals(puolustusjoukot>hyokkaysjoukot,true);     
  }
    
}
