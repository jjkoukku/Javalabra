package bthelsinki;

import java.awt.Color;

public class Pelaaja{
    
    private String nimi;
    private boolean tyhjaRuutu = false;
    private Color vari;
    private Ruutu hq;

    
    public Pelaaja(String nimi, Color vari) { // tavalliselle pelaajalle annetaan nimi
        this.nimi = nimi;
        this.vari = vari;
    }
    
    public Pelaaja() {            // tyhjien ruutujen käyttäjä luodaan tällä konstruktorilla
        this.nimi = "h";
        tyhjaRuutu = true;
        this.vari= Color.GRAY;
    }

    public boolean isTyhjaRuutu() {
        return tyhjaRuutu;
    }

    public String getNimi() {
        return nimi;
    }
    
    public Color getVari(){
        return this.vari;
    }

    public void setHq(Ruutu hq) {
        this.hq = hq;
    }

    public Ruutu getHq() {
        return hq;
    }
    
    
    
    @Override
    public String toString() {   // 
        return this.nimi;
        
    }
    
}