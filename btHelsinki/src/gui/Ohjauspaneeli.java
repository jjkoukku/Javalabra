package gui;

import bthelsinki.Peli;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ohjauspaneeli {

private JPanel paneeli;
private GridLayout layout;
private Peli peli;
private JLabel vuorossaOlevaPelaaja;

    public Ohjauspaneeli(Peli peli) {
        this.peli = peli;        
        paneeli = new JPanel();
        GridLayout layout = new GridLayout(2,3);
        paneeli.setLayout(layout);
        
        
        JLabel lahtoKoordinaattiLabel = new JLabel("Lähtö:");
        JTextArea lahtoNaatit = new JTextArea("1,1");
        vuorossaOlevaPelaaja = new JLabel("Pelaaja X");
        
        JButton lopetaNappi = new JButton("Lopeta");
        lopetaNappi.addActionListener(new OhPaVuoroKuuntelija(peli,vuorossaOlevaPelaaja));
        
        JLabel kohdeKoordinaattiLabel = new JLabel("Kohde:");
        JTextArea kohdeNaatit = new JTextArea("2,2");   
        
        JTextArea joukot = new JTextArea("0");
        
        paneeli.add(vuorossaOlevaPelaaja);
        paneeli.add(lahtoKoordinaattiLabel);
        paneeli.add(kohdeKoordinaattiLabel);
        paneeli.add(lopetaNappi);
        paneeli.add(lahtoNaatit);
        paneeli.add(kohdeNaatit);
    }

    public JPanel getContainer(){
        return this.paneeli;
    }   
    
}