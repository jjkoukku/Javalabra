package gui.kuuntelijat;

import bthelsinki.Peli;
import gui.Ohjauspaneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class SiirraPaKuuntelija implements ActionListener {
    Peli peli;
    Ohjauspaneeli ohPanel;
   
    public SiirraPaKuuntelija(Peli peli,Ohjauspaneeli ohPanel ){
        this.peli=peli;
        this.ohPanel = ohPanel;
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {       
        peli.siirra(ohPanel.getLNaatit(), ohPanel.getKNaatit(), ohPanel.getJoukot());
        ohPanel.getRuudukko().paivitaRuudut();
    }
}