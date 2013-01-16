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
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    @Override
    public String toString() {
        String rTiedot ="<< " + yksikot + "," + omistaja + "," + pelattava + " >>";  
        return rTiedot; 
    }
     
}