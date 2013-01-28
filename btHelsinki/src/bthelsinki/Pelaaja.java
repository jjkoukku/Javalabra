package bthelsinki;
public class Pelaaja{
    
    private String vari;
    boolean tyhjaRuutu = false;

    
    public Pelaaja(String vari) { // tavalliselle pelaajalle annetaan väri
        this.vari = vari;     
    }
    
    public Pelaaja() {            // tyhjien ruutujen käyttäjä luodaan tällä konstruktorilla
        this.vari = "h";
        tyhjaRuutu = true;
    }

    public boolean isTyhjaRuutu() {
        return tyhjaRuutu;
    }

    public String getVari() {
        return vari;
    }
    
    @Override
    public String toString() {   // 
        return this.vari;
        
    }
    
}