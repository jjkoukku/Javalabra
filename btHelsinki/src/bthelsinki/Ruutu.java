package bthelsinki;
public class Ruutu{

private int x; // x,y koordinaatit
private int y; // 
private boolean pelattava = true;
private int yksikot=0;
private Pelaaja omistaja;
private Pelaaja hq;

/** Luo tavanomaisen ruudun, jolle oletusarvoisesti laitetaan omistajaksi
 *  ns.harmaa pelaaja
 * 
 * @param x annetun ruudun x koordinaatti -1
 * @param y annetun ruudun y koordinaatti -1
 */
    public Ruutu(int x, int y){
        this.x = x+1;
        this.y = y+1;
        omistaja = new Pelaaja(); // luo tyhjien ruutujen "harmaan" pelaajan.
    }
    
    /**
     * Luo ns. virheruudun, johon viitataan vain jos yritetään hakea pelilaudan ulkopuolista ruutua.
     */
    
    public Ruutu(){ // ruututyyppi, joka palautetaan kun yritetään hakea ulkopuolista ruutua
        this.x = -100;
        this.y = -100;
        omistaja = new Pelaaja(); // luo tyhjien ruutujen "harmaan" pelaajan.
        pelattava= false;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean getPelattava(){
        return pelattava;
    }
    
    public void setYksikot(int yksikot) {
        this.yksikot = yksikot;
    }    

    public int getYksikot() {
        return yksikot;
    }

    public Pelaaja getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(Pelaaja omistaja) {
        this.omistaja = omistaja;
    }

    public void setHq() {
        this.hq = omistaja;
    }

    public Pelaaja getHq() {
        return hq;
    }
    
    
    /**
     * 
     * @return Palauttaa ruudun tiedot muodossa:
     * "<< " + 'yksiköiden lkm' , 'omistaja' ,'onko ruutu pelialueella(True/False)' >>"
     */
    @Override
    public String toString() {
        String rTiedot ="<< " + yksikot + "," + omistaja + "," + pelattava + " >>";  
        return rTiedot; 
    }
     
}