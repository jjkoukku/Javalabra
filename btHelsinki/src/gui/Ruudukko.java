package gui;

import bthelsinki.Peli;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Ruudukko {

    private Container container = new Container();
    private Peli peli;
    private Ohjauspaneeli ohPanel;

    public Ruudukko(Peli peli, Ohjauspaneeli ohPanel) {
        this.peli = peli;
        this.ohPanel = ohPanel;
        int korkeus = peli.getPelilauta().getKorkeus();
        int leveys =  peli.getPelilauta().getLeveys();
        GridLayout layout = new GridLayout(korkeus,leveys);
        container.setLayout(layout);        
        for (int i = 1; i <= leveys; i++) {
            for (int j = 1; j <= korkeus; j++) {
                container.add(new GRuutu(peli, peli.getPelilauta().getRuutu(j, i), ohPanel));
            }
        }        
    }

    public Container getContainer() {
        return this.container;
    }
}