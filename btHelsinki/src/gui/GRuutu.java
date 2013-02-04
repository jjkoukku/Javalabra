package gui;

import gui.kuuntelijat.RuutuKuuntelija;
import bthelsinki.Peli;
import bthelsinki.Ruutu;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


public final class GRuutu extends JLabel  {
    
    private Peli peli;
    private Ruutu ruutu;
    private Ohjauspaneeli ohPanel;
    /** Luo graafisen ilmentymän ruudusta
     * 
     * @param peli käynnissäolevan pelin olio
     * @param ruutu vastaavan loogisen ruudun ilmentymä pelissä
     * @param ohPanel GUI:n alapalkin ilmentymä
     */
    public GRuutu(Peli peli,Ruutu ruutu,Ohjauspaneeli ohPanel) {
        super("Ruutu");
        this.peli = peli;
        this.ruutu = ruutu;
        this.ohPanel=ohPanel;
        this.setOpaque(true);
        this.addMouseListener(new RuutuKuuntelija(this, ohPanel));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.paivita();        
        }
 
    /**
     * Päivittää ruudun näytöllä vastaamaan käynnissä olevan pelin tilannetta
     */
    
    public void paivita(){
        super.setText(""+ruutu.getYksikot());
        this.setBackground(ruutu.getOmistaja().getVari());
    }
    
    /**
     * 
     * @return Palauttaa pelilogiikan ruudun olio-viittauksen, Huom.! Ei graafista-Gruutua.
     */
    
    public Ruutu getRuutu(){
        return ruutu;
    }
    
    }


