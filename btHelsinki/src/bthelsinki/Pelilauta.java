
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
    
    
    public void tulostaRuudukko(){
        
        for (int i = 0; i < leveys*korkeus - 1; i++) {        
        System.out.print(ruudukko.get(i) + " ");
        if (ruudukko.get(i).getX()<ruudukko.get(i+1).getX()) {
            System.out.println("");
        }

        }
        System.out.print(ruudukko.get(leveys*korkeus-1));
    }
}
