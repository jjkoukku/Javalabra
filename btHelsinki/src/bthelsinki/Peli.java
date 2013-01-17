/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

public class Peli {

private Pelilauta pelilauta;

private Pelaaja tyhjat = new Pelaaja();

    public Peli(Pelilauta pelilauta, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelilauta = pelilauta;        
        pelilauta.muutaYksikoita(1, 1, 10);
        pelilauta.setOmistaja(1, 1, pelaaja1);
        pelilauta.muutaYksikoita(pelilauta.getLeveys(), pelilauta.getKorkeus(), 10);
        pelilauta.setOmistaja(pelilauta.getLeveys(), pelilauta.getKorkeus(), pelaaja2);
    }
        

    
}
