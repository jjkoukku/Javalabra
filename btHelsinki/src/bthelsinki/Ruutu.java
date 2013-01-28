package bthelsinki;
public class Ruutu{

private int x; // x,y koordinaatit
private int y; // 
private boolean pelattava = true;
private int yksikot=0;
private Pelaaja omistaja;


    public Ruutu(int x, int y){
        this.x = x+1;
        this.y = y+1;
        omistaja = new Pelaaja(); // luo tyhjien ruutujen "harmaan" pelaajan.
    }
    
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
    
    
    
    
    @Override
    public String toString() {
        String rTiedot ="<< " + yksikot + "," + omistaja + "," + pelattava + " >>";  
        return rTiedot; 
    }
     
}