package bthelsinki;
public class Pelaaja{
    
    private String nimi = "pelaaja";
    private boolean ai = false;
    
    public Pelaaja(String nimi, boolean ai) {
        this.nimi = nimi;
        this.ai= ai;
    }

    @Override
    public String toString() {
        return nimi;
    }
    
}