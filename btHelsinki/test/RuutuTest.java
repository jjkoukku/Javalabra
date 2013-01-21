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


/**
 *
 * @author jjkoukku
 */
public class RuutuTest {
    
    public RuutuTest() {
    }
    
    @Test
  public void konstruktoriOikein() {
      Ruutu ruutu = new Ruutu(1,1);      
      assertEquals(ruutu.getOmistaja().toString(), "h");
  }

}
