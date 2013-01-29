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
    
    public OhPaVuoroKuuntelija(Peli peli,JLabel teksti, Ohjauspaneeli ohPanel ){
        this.peli=peli;
        this.teksti = teksti;
        this.ohPanel = ohPanel;
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.lopetaVuoro();
        ohPanel.getRuudukko().paivitaRuudut();
        teksti.setText("Vuorossa on " + peli.getvuorossaOleva().toString());
    }
}