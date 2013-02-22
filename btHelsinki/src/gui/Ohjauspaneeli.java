package gui;

import bthelsinki.Peli;
import gui.kuuntelijat.OhPaVuoroKuuntelija;
import gui.kuuntelijat.SiirraPaKuuntelija;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Ohjauspaneeli {

private JPanel paneeli;
private GridLayout layout;
private Peli peli;
private JLabel vuorossaOlevaPelaaja;
private JLabel lahtonaatitLab;
private JLabel kohdenaatitLab;
private JSpinner joukotSpin;
private int[] lahtoNaatit = {0,0};
private int[] kohdeNaatit = {0,0};
private int joukot=0;
private Ohjauspaneeli ohPanel;
private Ruudukko ruudukko;

/**
 * Luo Pelin perusteella ohjauspaneelin
 * @param peli Looginen peliolio, jonka kanssa ohjauspaneeli on vuorovaikutuksessa
 */
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
        
        joukotSpin = new JSpinner(new SpinnerNumberModel());
        joukotSpin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        paneeli.add(vuorossaOlevaPelaaja);        
        paneeli.add(lahtoKoordinaattiLabel);
        paneeli.add(kohdeKoordinaattiLabel);
        paneeli.add(siirraNappi);
        paneeli.add(lopetaNappi);
        paneeli.add(lahtonaatitLab);
        paneeli.add(kohdenaatitLab);
        paneeli.add(joukotSpin);        
    }
    
    /**
     * Graafinen ruudukko, jonka kanssa ohjauspaneeli on vuorovaikutuksessa
     * @param ruudukko 
     */
    
    public void setRuudukko(Ruudukko ruudukko){
        this.ruudukko=ruudukko;
    }
    
    public Ruudukko getRuudukko(){
        return ruudukko;
    }
    
    public JPanel getContainer(){
        return this.paneeli;
    }   
    
    /**
     * Ohjauspaneelissa tekstikentässä näkyvän lähtöruudun koordinaatit int-muodosa
     * @param x
     * @param y 
     */
    public void setLahto(int x, int y){
        lahtoNaatit[0]=x;
        lahtoNaatit[1]=y;
        lahtonaatitLab.setText(lahtoNaatit[0] + "," + lahtoNaatit[1]);
    }
        /**
     * Ohjauspaneelissa tekstikentässä näkyvän kohderuudun koordinaatit int-muodosa
     * @param x
     * @param y 
     */
    public void setKohde(int x, int y){
        kohdeNaatit[0]=x;
        kohdeNaatit[1]=y;
        kohdenaatitLab.setText(kohdeNaatit[0] + "," + kohdeNaatit[1]);       
    }
            /**
     * Ohjauspaneelissa näkyvä siirrettävien joukkojen määrä
     * @param m 
     */
    public void setJoukot(int m){
        joukot = m;
        joukotSpin.setValue(new Integer(m));
    }   
    /**
     * Palauttaa ohjauspaneelin Siirrettävien joukkojen määrä parsemalla kokonais-
     * luvut txt-boxista.
     * @return 
     */
    public int getJoukot(){
        return joukotSpin.getValue().hashCode();
    } 
    
    public int[] getLNaatit() {
        return lahtoNaatit;
    }
    
    public int[] getKNaatit() {
        return kohdeNaatit;
    }
    
    public void setVisibility(Boolean v){
        paneeli.setVisible(v);
    }
    
    

}
    
