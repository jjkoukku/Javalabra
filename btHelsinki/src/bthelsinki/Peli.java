/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

public class Peli {

private Pelilauta pelilauta;
private boolean lopetus = false;

    public Peli(Pelilauta pelilauta, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelilauta = pelilauta;
        Ruutu alRuutu1pe = pelilauta.getRuutu(1, 1); //aloitusruudut vastakkaisissa reunoissa.
        Ruutu alRuutu2pe = pelilauta.getRuutu(pelilauta.getLeveys(), pelilauta.getKorkeus());
        alRuutu1pe.setYksikot(10);
        alRuutu1pe.setOmistaja(pelaaja1);
        alRuutu2pe.setYksikot(10);
        alRuutu2pe.setOmistaja(pelaaja2);
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }
    
    
    
    public void aloita(){
        while(lopetus) {
            
        }
    }
        

    
}
