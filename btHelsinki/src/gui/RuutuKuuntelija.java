package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RuutuKuuntelija implements MouseListener {

    private GRuutu ruutu;
    private Ohjauspaneeli ohPanel;

    public RuutuKuuntelija(GRuutu ruutu, Ohjauspaneeli ohPanel) {
        this.ruutu = ruutu;
        this.ohPanel = ohPanel;
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            ohPanel.setLahto(ruutu.getRuutu().getX(), ruutu.getRuutu().getY());
            System.out.println(ruutu.getRuutu().getX()+ "," + ruutu.getRuutu().getY());
        }
        else if (e.getButton() == 3) {
            ohPanel.setKohde(ruutu.getRuutu().getX(), ruutu.getRuutu().getY());
            System.out.println(ruutu.getRuutu().getX()+ "," + ruutu.getRuutu().getY());
        } else {
            System.out.println("Näppäimelle ei ole määritelty tehtävää");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
}