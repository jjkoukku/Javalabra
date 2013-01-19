/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;

import txtUI.TxtUI;

public class Peli {

    private Pelilauta pelilauta;
    private TxtUI gui;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;

    public Peli(Pelilauta pelilauta, TxtUI gui, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelilauta = pelilauta;
        this.gui = gui;
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

    public void aloita() {
        while (true) {
            gui.naytaPelilauta(this);
            if (vuoro(pelaaja1)) {
                break;
            }
            gui.naytaPelilauta(this);
            if (vuoro(pelaaja2)) {
                break;
            }
//            if (gui.askLopetus()) break;
        }
        gui.iPelinLoppu();
    }

    private boolean vuoro(Pelaaja pelaaja) {
        gui.iVuoronAlku(pelaaja.toString());
        while (gui.askLopetatkoVuoron()) {
            System.out.println("anna lähtöruutu");
            int[] lahtoNaatit = gui.askKoordinaatit();
            System.out.println("anna loppuruutu");
            int[] loppuNaatit = gui.askKoordinaatit();
            Ruutu lruutu = pelilauta.getRuutu(lahtoNaatit[0], lahtoNaatit[1]);
            Ruutu kruutu = pelilauta.getRuutu(loppuNaatit[0], loppuNaatit[1]);
            System.out.println("Anna siirrettävien yksiköiden määrä");
            int maara = gui.askMaara();
            pelilauta.siirto(lruutu, kruutu, maara, pelaaja);
        }

        return false;
    }
}
