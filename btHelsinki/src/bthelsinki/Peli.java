/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

import txtUI.TxtUI;

public class Peli {

    private Pelilauta pelilauta;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    Pelaaja vuorossaOleva;

    public Peli(Pelilauta pelilauta, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelilauta = pelilauta;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
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

    public Pelaaja getvuorossaOleva(){
        return vuorossaOleva;
    }
    
    public void lopetaVuoro(){
        if (vuorossaOleva == pelaaja1){
            vuorossaOleva = pelaaja2;
        }
        if (vuorossaOleva == pelaaja2){
            vuorossaOleva = pelaaja1;
        }
    }
    
    private boolean vuoro(Pelaaja pelaaja) {
        
        return false;
    }
    
}
