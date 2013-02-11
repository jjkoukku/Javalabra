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
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
public class PaaIkkuna implements Runnable {

    private JFrame frame;
    private Peli peli;
    private Taustakuva bg;
    private int leveys;
    private int korkeus;
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
        bg = new Taustakuva();
        this.leveys = bg.getPreferredSize().width;
        this.korkeus = bg.getPreferredSize().height;
        frame.setPreferredSize(new Dimension(leveys+15,korkeus+80));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void luoKomponentit(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

       // ohjauspaneeli, josta vuoroa vaihdetaan ja syötetään koordinaatteja  
        Ohjauspaneeli ohPanel= new Ohjauspaneeli(peli);
        
       //luodaan "kartta"
        Ruudukko pelikartta = new Ruudukko(peli, ohPanel,bg);
        ohPanel.setRuudukko(pelikartta);
        pelikartta.getContainer().setBounds(0, 0, leveys, korkeus);
        bg.setBounds(0, 0, leveys, korkeus);
        
       
        //sijoitetaan tavarat ruudukkoon
        JLayeredPane kerros = new JLayeredPane();
        kerros.add(bg,new Integer(0),0);
        kerros.add(pelikartta.getContainer(),new Integer(1),0);
        
         
        container.add(kerros,BorderLayout.CENTER);  
        container.add(ohPanel.getContainer(),BorderLayout.SOUTH);
    }
    
}