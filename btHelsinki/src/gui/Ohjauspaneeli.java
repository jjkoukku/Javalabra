package gui;

import bthelsinki.Peli;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ohjauspaneeli {

private JPanel paneeli;
private GridLayout layout;
private Peli peli;
private JLabel vuorossaOlevaPelaaja;
private JTextArea lahtonaatitTxt;
private JTextArea kohdenaatitTxt;
private JTextArea joukotTxt;
private int[] lahtoNaatit = {0,0};
private int[] kohdeNaatit = {0,0};
private int joukot=0;

    public Ohjauspaneeli(Peli peli) {
        this.peli = peli;        
        paneeli = new JPanel();
        GridLayout layout = new GridLayout(2,3);
        paneeli.setLayout(layout);
        
        
        JLabel lahtoKoordinaattiLabel = new JLabel("Lähtö:");
        lahtonaatitTxt = new JTextArea(lahtoNaatit[0] + "," + lahtoNaatit[1]);
        vuorossaOlevaPelaaja = new JLabel("Pelaaja X");
        
        JButton lopetaNappi = new JButton("Lopeta");
        lopetaNappi.addActionListener(new OhPaVuoroKuuntelija(peli,vuorossaOlevaPelaaja));
        
        JLabel kohdeKoordinaattiLabel = new JLabel("Kohde:");
        kohdenaatitTxt = new JTextArea(kohdeNaatit[0] + "," + kohdeNaatit[1]);   
        
        joukotTxt = new JTextArea("0");
        
        paneeli.add(vuorossaOlevaPelaaja);
        paneeli.add(lahtoKoordinaattiLabel);
        paneeli.add(kohdeKoordinaattiLabel);
        paneeli.add(lopetaNappi);
        paneeli.add(lahtonaatitTxt);
        paneeli.add(kohdenaatitTxt);
    }

    public JPanel getContainer(){
        return this.paneeli;
    }   
    
    public void setLahto(int x, int y){
        lahtoNaatit[0]=x;
        lahtoNaatit[1]=y;
        lahtonaatitTxt.setText(lahtoNaatit[0] + "," + lahtoNaatit[1]);
    }
    
    public void setKohde(int x, int y){
        kohdeNaatit[0]=x;
        kohdeNaatit[1]=y;
        kohdenaatitTxt.setText(kohdeNaatit[0] + "," + kohdeNaatit[1]);       
    }
    
    public void setJoukot(int m){
        joukot = m;
        joukotTxt.setText("" + m);
    }   
    
}