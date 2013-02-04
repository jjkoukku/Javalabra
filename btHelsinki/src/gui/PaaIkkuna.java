package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import bthelsinki.Peli;
import java.awt.BorderLayout;
import gui.kuvahallinta.Taustakuva;
public class PaaIkkuna implements Runnable {

    private JFrame frame;
    private Peli peli;
    /**
     * Luo pelin Gui:n pääikkunan joka sisältää seuraavaksi isoimmat kokonaisuudet:
     * ruudukon ja ohjauspaneelin.
     * @param peli 
     */
    public PaaIkkuna(Peli peli) {
        this.peli = peli;
    }
    /**
     * Käynnistettäessä suoritettava metodi.
     */
    @Override
    public void run() {
        frame = new JFrame("Battle of Ruudukko");
        frame.setPreferredSize(new Dimension(600, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
       
       // ohjauspaneeli, josta vuoroa vaihdetaan ja syötetään koordinaatteja  
        Ohjauspaneeli ohPanel= new Ohjauspaneeli(peli);
        
       //luodaan "kartta"
        Ruudukko pelikartta = new Ruudukko(peli, ohPanel);     
        ohPanel.setRuudukko(pelikartta);
      //sijoitetaan tavarat ruudukkoon
        container.add(pelikartta.getContainer(), BorderLayout.CENTER);
        container.add(ohPanel.getContainer(),BorderLayout.SOUTH);
    }


    
    
}