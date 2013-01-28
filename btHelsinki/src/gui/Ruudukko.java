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

    public Ruudukko(Peli peli) {
        this.peli = peli;
        int korkeus = peli.getPelilauta().getKorkeus();
        int leveys =  peli.getPelilauta().getLeveys();
        GridLayout layout = new GridLayout(korkeus,leveys);
        container.setLayout(layout);        
        for (int i = 0; i < korkeus*leveys; i++) {
            container.add(new JTextArea((i + 1)+""));
        }
        
    }

    public Container getContainer() {
        return this.container;
    }
}