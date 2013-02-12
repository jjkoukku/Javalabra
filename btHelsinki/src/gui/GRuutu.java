package gui;

import gui.kuuntelijat.RuutuKuuntelija;
import bthelsinki.Peli;
import bthelsinki.Ruutu;
import gui.kuvahallinta.Taustakuva;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public final class GRuutu extends JLabel {

    private Peli peli;
    private Ruutu ruutu;
    private Ohjauspaneeli ohPanel;
    private Color lapinakyva = new Color(0, 0, 0, 0);
    private Boolean hq = false;

    /**
     * Luo graafisen ilmentymän ruudusta
     *
     * @param peli käynnissäolevan pelin olio
     * @param ruutu vastaavan loogisen ruudun ilmentymä pelissä
     * @param ohPanel GUI:n alapalkin ilmentymä
     */
    public GRuutu(Peli peli, Ruutu ruutu, Ohjauspaneeli ohPanel) {
        super("Ruutu");
        this.peli = peli;
        this.ruutu = ruutu;
        this.ohPanel = ohPanel;
        this.addMouseListener(new RuutuKuuntelija(this, ohPanel));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        Font f = new Font("Comic sans", Font.BOLD, 25);
        this.setForeground(Color.YELLOW);
        this.setFont(f);
        this.paivita();
        this.setOpaque(true);
//        this.setBackground(this.vari);
    }

    public void setHq(Boolean hq) {
        this.hq = hq;
    }

    /**
     * Päivittää ruudun näytöllä vastaamaan käynnissä olevan pelin tilannetta
     */
    public void paivita() {
        this.setText(ruudunInfo());
        Color pv = ruutu.getOmistaja().getVari();
        Color rvari = new Color(pv.getRed(), pv.getGreen(), pv.getBlue(), 60);

        if (pv.equals(Color.GRAY)) { //harmaan pelaajan ruutuja ei jaksa korostella
            rvari = lapinakyva;
        }
        paivitaReunat(pv);

        this.setBackground(rvari);
    }

    private void paivitaReunat(Color vari) {
        Border reunat = (BorderFactory.createLineBorder(vari, 5));
        if (hq) {
            reunat = BorderFactory.createTitledBorder(reunat, "HQ");
        }
        this.setBorder(reunat);
    }

    private String ruudunInfo() {
        if (this.ruutu.getYksikot() == 0) {
            return "";
        } else {
            return "" + this.ruutu.getYksikot();
        }
    }

    /**
     *
     * @return Palauttaa pelilogiikan ruudun olio-viittauksen, Huom.! Ei
     * graafista-Gruutua.
     */
    public Ruutu getRuutu() {
        return ruutu;
    }
}
