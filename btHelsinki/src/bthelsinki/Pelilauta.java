
package bthelsinki;
import java.util.ArrayList;

public class Pelilauta{

private int leveys;
private int korkeus;
private ArrayList<Ruutu> ruudukko = new ArrayList<Ruutu>();

    public Pelilauta(int leveys,int korkeus) {
       
       this.leveys = leveys;
       this.korkeus = korkeus;
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {            
            ruudukko.add(new Ruutu(i,j));
            }
        }
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }
    
    
    
    public boolean muutaYksikoita (int x, int y, int uusiluku) {
        int jluku = this.naatitJarjluvuks(x, y);
        ruudukko.get(jluku).setYksikot(uusiluku);
        return true;
    }
    
    public boolean setOmistaja(int x, int y, Pelaaja pelaaja){        
        ruudukko.get(this.naatitJarjluvuks(x, y)).setOmistaja(pelaaja);
        return true;
    }
    
    public void tulostaRuudukko(){
        
        for (int i = 0; i < leveys*korkeus - 1; i++) {        
            System.out.print(ruudukko.get(i) + " ");
        if (ruudukko.get(i).getX()<ruudukko.get(i+1).getX()) {
            System.out.println("");
        }

        }
        System.out.print(ruudukko.get(leveys*korkeus-1));
    }
    
    private int naatitJarjluvuks(int x, int y) { // sisainen metodi, palauttaa x,y koordinaatit
    int luku = (y-1)*this.leveys + x - 1;        // ruudukon järjestyslukuna ylävasemmalta lukien. Esim
                                                 // 3x3 ruudukossa 1 2 3
                                                 //                4 5 6
                                                 //                7 8 9
    return luku;
    }
}

