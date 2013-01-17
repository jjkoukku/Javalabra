/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

public class Peli {

private Pelilauta pelilauta;
    
    public Peli(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
        pelilauta.muutaYksikoita(1, 1, 10);
        pelilauta.muutaYksikoita(3, 3, 10);
    }
        
    
    
}
