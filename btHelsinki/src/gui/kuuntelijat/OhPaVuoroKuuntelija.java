package gui.kuuntelijat;

import bthelsinki.Peli;
import gui.Ohjauspaneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class OhPaVuoroKuuntelija implements ActionListener {
    Peli peli;
    JLabel teksti;
    Ohjauspaneeli ohPanel;
    /**
     * Luo vuoronvaihtumisen painikkeen kuuntelijan
     * @param peli
     * @param teksti
     * @param ohPanel 
     */
    public OhPaVuoroKuuntelija(Peli peli,JLabel teksti, Ohjauspaneeli ohPanel ){
        this.peli=peli;
        this.teksti = teksti;
        this.ohPanel = ohPanel;
    }
    /**
     * Painettaessa jotain painiketta, vuorossa oleva vaihtuu.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.lopetaVuoro();
        ohPanel.getRuudukko().paivitaRuudut();
        teksti.setText("Vuorossa on " + peli.getvuorossaOleva().toString());
    }
}