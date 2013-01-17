package bthelsinki;
public class Pelaaja{
    
    private String vari;

    
    public Pelaaja(String vari) {
        this.vari = vari;     
    }

    @Override
    public String toString() {
        return this.vari;
    }
    
}