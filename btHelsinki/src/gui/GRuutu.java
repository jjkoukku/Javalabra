package gui;

import gui.kuuntelijat.RuutuKuuntelija;
import bthelsinki.Peli;
import bthelsinki.Ruutu;
import gui.kuvahallinta.Taustakuva;
import java.awt.Color;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public final class GRuutu extends JLabel  {
    
    private Peli peli;
    private Ruutu ruutu;
    private Ohjauspaneeli ohPanel;
    private Color vari = new Color(0,0,0,0);
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
        this.addMouseListener(new RuutuKuuntelija(this, ohPanel));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.paivita();
        this.setOpaque(true);
        this.setBackground(this.vari);
        }
 
    /**
     * Päivittää ruudun näytöllä vastaamaan käynnissä olevan pelin tilannetta
     */
    
    public void paivita(){
        this.setText(""+ruutu.getYksikot());
        this.setBorder(BorderFactory.createLineBorder(ruutu.getOmistaja().getVari(),5));
    }
    
    /**
     * 
     * @return Palauttaa pelilogiikan ruudun olio-viittauksen, Huom.! Ei graafista-Gruutua.
     */
    
    public Ruutu getRuutu(){
        return ruutu;
    }
    
    }


