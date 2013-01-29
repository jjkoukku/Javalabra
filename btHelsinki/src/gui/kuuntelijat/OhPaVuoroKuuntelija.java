package gui.kuuntelijat;

import bthelsinki.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class OhPaVuoroKuuntelija implements ActionListener {
    Peli peli;
    JLabel teksti;
    
    public OhPaVuoroKuuntelija(Peli peli,JLabel teksti ){
        this.peli=peli;
        this.teksti = teksti;
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.lopetaVuoro();
        teksti.setText("Vuorossa on " + peli.getvuorossaOleva().toString());
    }
}