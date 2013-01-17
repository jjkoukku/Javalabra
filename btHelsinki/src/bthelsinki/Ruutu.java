package bthelsinki;
public class Ruutu{

private int x; // x,y koordinaatit
private int y; // 
private boolean pelattava = true;
private int yksikot=0;
private Pelaaja omistaja;


    public Ruutu(int x, int y){
        this.x = x;
        this.y = y;
        omistaja = new Pelaaja(); // luo tyhjien ruutujen "harmaan" pelaajan.
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    
    
    
    
    @Override
    public String toString() {
        String rTiedot ="<< " + yksikot + "," + omistaja + "," + pelattava + " >>";  
        return rTiedot; 
    }
     
}