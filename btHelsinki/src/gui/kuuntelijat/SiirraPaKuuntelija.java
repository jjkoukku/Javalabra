package gui.kuuntelijat;

import bthelsinki.Peli;
import gui.Ohjauspaneeli;
import gui.PonIkkuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SiirraPaKuuntelija implements ActionListener {
    Peli peli;
    Ohjauspaneeli ohPanel;
   /**
    * Luo Siirrä painikkeen kuuntelijan
    * @param peli peliloogikan olio, jonka kanssa GUI on vuorovaikutuksessa.
    * @param ohPanel GUI Ohjauspaneeli
    */
    public SiirraPaKuuntelija(Peli peli,Ohjauspaneeli ohPanel ){
        this.peli=peli;
        this.ohPanel = ohPanel;
    }
            /** Pyytää peliä tekemään siirron.
             * Siirron jälkeen tarkistaa onko peli ohi, ja mikäli on, piilottaa
             * ohjauspaneelin ja estää täten pelin jatkumisen.
             * @param ae 
             */
    @Override
    public void actionPerformed(ActionEvent ae) {       
        
        peli.siirra(ohPanel.getLNaatit(), ohPanel.getKNaatit(), ohPanel.getJoukot());
        ohPanel.getRuudukko().paivitaRuudut();
                        
        if (peli.onkoPeliOhi()) {
            PonIkkuna.ilmoita("Pelaaja '" + peli.getVoittaja() + "' voitti pelin. Kiitos ja näkemiin!");
            ohPanel.setVisibility(false);
        }
        
    }
}