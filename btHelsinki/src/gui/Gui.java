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
public class Gui implements Runnable {

    private JFrame frame;
    private Peli peli;
    
    public Gui(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Battle of Ruudukko");
        frame.setPreferredSize(new Dimension(900, 900));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
      //luodaan "kartta"
        Ruudukko pelikartta = new Ruudukko(peli);
        container.add(pelikartta.getContainer(), BorderLayout.CENTER);
      // ohjauspaneeli, josta vuoroa vaihdetaan ja syötetään koordinaatteja  
        Ohjauspaneeli ohPanel= new Ohjauspaneeli(peli);
        container.add(ohPanel.getContainer(),BorderLayout.SOUTH);   
    }

    public JFrame getFrame() {
        return frame;
    }
    
    
}