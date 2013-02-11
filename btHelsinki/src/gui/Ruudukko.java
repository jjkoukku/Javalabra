package gui;

import bthelsinki.Peli;
import gui.kuvahallinta.Taustakuva;
import java.awt.Color;
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
    private GRuutu[][] gRuudukko;
    private int korkeus;
    private int leveys;
    private Taustakuva bg;
    
    /**
     * Luo ruudukon, joka koostuu ruuduista
     * @param peli Pelilogiikan peliolio, jonka kanssa GUI/ruudukko on vuorovaikutuksessa.
     * @param ohPanel GUI:n ohjauspaneeli, jonka kanssa ruudukko on vuorovaikutuksessa
     */
    
    public Ruudukko(Peli peli, Ohjauspaneeli ohPanel, Taustakuva bg) {
        this.peli = peli;
        this.ohPanel = ohPanel;
        this.bg = bg;
        this.korkeus = peli.getPelilauta().getKorkeus();
        this.leveys =  peli.getPelilauta().getLeveys();
        GridLayout layout = new GridLayout(korkeus,leveys);
     
        container.setLayout(layout);
        gRuudukko = new GRuutu[leveys+1][korkeus+1];
        
        for (int i = 1; i <= leveys; i++) {
            for (int j = 1; j <= korkeus; j++) {                
                gRuudukko[i][j]=new GRuutu(peli, peli.getPelilauta().getRuutu(j, i), ohPanel);
                container.add(gRuudukko[i][j]);
            }          
        }        
    }

    public Container getContainer() {
        return this.container;
    }
    
    public GRuutu getGRuutu(int x,int y){
        return gRuudukko[x][y];
    }
    /**
     * Kutsuu jokaisen ruudukon ruudun päivitä metodia, ja päivittää siten kaikki graafiset ruudut
     * vastaamaan taustalla olevan loogisen pelin todellista tilannetta.
     */
    
    public void paivitaRuudut(){
        for (int i = 1; i < leveys+1; i++) {
            for (int j = 1; j < korkeus+1; j++) {
                gRuudukko[i][j].paivita();
            }
            bg.repaint();
        }
    }
            
}