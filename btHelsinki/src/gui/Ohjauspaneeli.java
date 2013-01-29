package gui;

import gui.kuuntelijat.OhPaVuoroKuuntelija;
import gui.kuuntelijat.SiirraPaKuuntelija;
import bthelsinki.Peli;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.lang.Integer;
import javax.swing.BorderFactory;

public class Ohjauspaneeli {

private JPanel paneeli;
private GridLayout layout;
private Peli peli;
private JLabel vuorossaOlevaPelaaja;
private JLabel lahtonaatitLab;
private JLabel kohdenaatitLab;
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
        lahtonaatitLab = new JLabel(lahtoNaatit[0] + "," + lahtoNaatit[1]);
        lahtonaatitLab.setBackground(Color.white);
        lahtonaatitLab.setOpaque(true);
        
        vuorossaOlevaPelaaja = new JLabel("Vuorossa on " + peli.getvuorossaOleva().toString());
        JButton lopetaNappi = new JButton("Lopeta vuoro");
        lopetaNappi.addActionListener(new OhPaVuoroKuuntelija(peli,vuorossaOlevaPelaaja,this));
        
        JButton siirraNappi = new JButton("Siirrä");
        siirraNappi.addActionListener(new SiirraPaKuuntelija(peli,this));
        
        JLabel kohdeKoordinaattiLabel = new JLabel("Kohde:");
        kohdenaatitLab = new JLabel(kohdeNaatit[0] + "," + kohdeNaatit[1]);   
        kohdenaatitLab.setBackground(Color.white);
        kohdenaatitLab.setOpaque(true);
        
        joukotTxt = new JTextArea("0");
        joukotTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        paneeli.add(vuorossaOlevaPelaaja);        
        paneeli.add(lahtoKoordinaattiLabel);
        paneeli.add(kohdeKoordinaattiLabel);
        paneeli.add(siirraNappi);
        paneeli.add(lopetaNappi);
        paneeli.add(lahtonaatitLab);
        paneeli.add(kohdenaatitLab);
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
        lahtonaatitLab.setText(lahtoNaatit[0] + "," + lahtoNaatit[1]);
    }
    
    public void setKohde(int x, int y){
        kohdeNaatit[0]=x;
        kohdeNaatit[1]=y;
        kohdenaatitLab.setText(kohdeNaatit[0] + "," + kohdeNaatit[1]);       
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