package gui;

import bthelsinki.Peli;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.lang.Integer;

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
private Ohjauspaneeli ohPanel;
private Ruudukko ruudukko;

    public Ohjauspaneeli(Peli peli) {
        this.peli = peli;        
        paneeli = new JPanel();
        GridLayout layout = new GridLayout(2,4);
        paneeli.setLayout(layout);
        
        
        JLabel lahtoKoordinaattiLabel = new JLabel("Lähtö:");
        lahtonaatitTxt = new JTextArea(lahtoNaatit[0] + "," + lahtoNaatit[1]);
        vuorossaOlevaPelaaja = new JLabel("Pelaaja X");
        
        JButton lopetaNappi = new JButton("Lopeta vuoro");
        lopetaNappi.addActionListener(new OhPaVuoroKuuntelija(peli,vuorossaOlevaPelaaja));
        
        JButton siirraNappi = new JButton("Siirrä");
        siirraNappi.addActionListener(new SiirraPaKuuntelija(peli,this));
        
        JLabel kohdeKoordinaattiLabel = new JLabel("Kohde:");
        kohdenaatitTxt = new JTextArea(kohdeNaatit[0] + "," + kohdeNaatit[1]);   
        
        joukotTxt = new JTextArea("0");
        
        paneeli.add(vuorossaOlevaPelaaja);        
        paneeli.add(lahtoKoordinaattiLabel);
        paneeli.add(kohdeKoordinaattiLabel);
        paneeli.add(siirraNappi);
        paneeli.add(lopetaNappi);
        paneeli.add(lahtonaatitTxt);
        paneeli.add(kohdenaatitTxt);
        paneeli.add(joukotTxt);
        
    }
    
    public void setRuudukko(Ruudukko ruudukko){
        this.ruudukko=ruudukko;
    }
    
    public Ruudukko getRuudukko(){
        return ruudukko;
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
    
    public int getJoukot(){
        return Integer.parseInt(joukotTxt.getText());
    } 
    
    public int[] getLNaatit() {
        return lahtoNaatit;
    }
    
    public int[] getKNaatit() {
        return kohdeNaatit;
    }
    
    
}