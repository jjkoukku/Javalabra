package gui;

import bthelsinki.Peli;
import bthelsinki.Ruutu;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JLabel;


public class GRuutu extends JLabel  {
    
    private Peli peli;
    private Ruutu ruutu;
    private Ohjauspaneeli ohPanel;
    
    public GRuutu(Peli peli,Ruutu ruutu,Ohjauspaneeli ohPanel) {
        super("Ruutu");
        this.peli = peli;
        this.ruutu = ruutu;
        this.ohPanel=ohPanel;
        super.setText(ruutu.toString());
        this.addMouseListener(new RuutuKuuntelija(this, ohPanel));
        }
 
    public void paivita(){
        super.setText(ruutu.toString());
    }
    
    public Ruutu getRuutu(){
        return ruutu;
    }
    
    }


