package gui.kuuntelijat;

import bthelsinki.Peli;
import gui.Ohjauspaneeli;
import gui.PIkkuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SiirraPaKuuntelija implements ActionListener {
    Peli peli;
    Ohjauspaneeli ohPanel;
   
    public SiirraPaKuuntelija(Peli peli,Ohjauspaneeli ohPanel ){
        this.peli=peli;
        this.ohPanel = ohPanel;
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {       
        
        if (peli.onkoPeliOhi() == false) {
        peli.siirra(ohPanel.getLNaatit(), ohPanel.getKNaatit(), ohPanel.getJoukot());
        ohPanel.getRuudukko().paivitaRuudut();
        }        
        
        if (peli.onkoPeliOhi()) {
            PIkkuna.ilmoita("Pelaaja '" + peli.getVoittaja() + "' voitti pelin. Kiitos ja näkemiin!");          
        }
        
    }
}