/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtUI;

/**
 *
 * @author joonas
 */
public class main {
    
    public static void main(String[] args) {
        TxtUI g = new TxtUI();
        int[] testitaulu = g.askKoordinaatit();
        int testimaara = g.askMaara();
        System.out.println("");
        System.out.println("**********");
        System.out.println("**********");
   
        System.out.println(testitaulu[0] + ", " + testitaulu[1]);
        System.out.println(testimaara);
    }  
}
