package gui.kuuntelijat;

import bthelsinki.Ruutu;
import gui.GRuutu;
import gui.Ohjauspaneeli;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RuutuKuuntelija implements MouseListener {

    private GRuutu gRuutu;
    private Ohjauspaneeli ohPanel;
    private Ruutu ruutu;

    /**
     * Luo  graafiselle ruudulle hiiri-kuuntelijan
     * @param gRuutu 
     * @param ohPanel 
     */
    public RuutuKuuntelija(GRuutu gRuutu, Ohjauspaneeli ohPanel) {
        this.gRuutu = gRuutu;
        this.ohPanel = ohPanel;
        this.ruutu = gRuutu.getRuutu();
    }
/**
 * Ei toimintoa
 * @param e 
 */
    @Override
    public void mouseExited(MouseEvent e) {
    }
/**
 * Ei toimintoa
 * @param e 
 */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    /**
     * Toteutuu, jos ruudusta painetaan, hiiren vasemmalla tai oikealla näpppäimellä.
     * Vasen näppäin vaihtaa konstrutorissa annetun ohjauspaneelin lähtöruudun koordinaatit,
     * sekä asettaa siirrettävien lkm samaksi kun mikä on ruudussa olevien yksiköiden määrä.
     * Vastaavasti hiiren oikeapainike, vaihtaa ohjauspaneelin kohderuudun koordinaattien
     * tilalle painetun ruudun koordinaatit.
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            ohPanel.setLahto(ruutu.getX(), ruutu.getY());
            System.out.println(ruutu.getX()+ "," + ruutu.getY());
            ohPanel.setJoukot(ruutu.getYksikot());
        }
        else if (e.getButton() == 3) {
            ohPanel.setKohde(ruutu.getX(), ruutu.getY());
            System.out.println(ruutu.getX()+ "," + ruutu.getY());
        } else {
            System.out.println("Näppäimelle ei ole määritelty tehtävää");
        }
    }
/**
 * Ei toimintoa
 * @param e 
 */
    @Override
    public void mouseReleased(MouseEvent e) {
    }
/**
 * Ei toimintoa
 * @param e 
 */
    @Override
    public void mouseEntered(MouseEvent e) {
    }
}