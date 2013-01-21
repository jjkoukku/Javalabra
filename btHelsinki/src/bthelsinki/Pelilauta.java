package bthelsinki;

import java.util.ArrayList;
import java.lang.Math;

public class Pelilauta {

    private int leveys;
    private int korkeus;
    private Ruutu[][] ruudukko;

    public Pelilauta(int leveys, int korkeus) {

        this.leveys = leveys;
        this.korkeus = korkeus;
        ruudukko = new Ruutu[leveys][korkeus];
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                ruudukko[i][j] = new Ruutu(i, j);
            }
        }
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public Ruutu getRuutu(int x, int y) {
        return ruudukko[x-1][y-1];
    }

    public Siirto siirtokasky(int[] lahto, int[] loppu, int maara, Pelaaja pelaaja) {       
        Siirto siirtotiedot;
        if (Tarkistukset(lahto, loppu, pelaaja, maara)){
            Ruutu lahtoruutu = this.getRuutu(lahto[0],lahto[1]);
            Ruutu loppuruutu = this.getRuutu(loppu[0],loppu[1]);
            siirtotiedot = new Siirto(lahtoruutu, loppuruutu, maara, pelaaja); // toistaseksi turhatoiminto...
            this.siirra(lahtoruutu,loppuruutu,maara,pelaaja);
        }
        else {
        siirtotiedot = new Siirto(false);    
        }
                
        return siirtotiedot;
    }
    
    private void siirra (Ruutu lahto, Ruutu loppu, int maara,Pelaaja pelaaja){
        if(pelaaja==loppu.getOmistaja()) { // rauhanomainen siirtyminen
           lahto.setYksikot(lahto.getYksikot()-maara);
           loppu.setYksikot(loppu.getYksikot()+maara); 
        }
        if(pelaaja!=loppu.getOmistaja()) { // Ei todellakaan rauhanomainen siirtyminen
            lahto.setYksikot(lahto.getYksikot()-maara); // sotilaat lähtevät
            int[] tulokset;                                         
            tulokset = Taistelu.taistele(maara,loppu.getYksikot()); // sotilaat taistelevat
            loppu.setYksikot(tulokset[1]);                          // puolustajat palaavat
                if(loppu.getYksikot()==0){
                    loppu.setOmistaja(pelaaja);
                    loppu.setYksikot(tulokset[0]);
                }
                else{
                    lahto.setYksikot(lahto.getYksikot()+tulokset[0]);
                }
                
        }
        
    }
    
    private boolean Tarkistukset(int[] lahto, int[] loppu, Pelaaja pelaaja, int maara){        
        boolean tarkistukset = false;
        //kriittiset kaatumisen estämiseksi
        
        boolean lahtoRuutu = onkoRuutuOlemassa(lahto);
        boolean loppuRuutu = onkoRuutuOlemassa(loppu);
        
        //krittiset siirron syntymiseksi
        if (lahtoRuutu && loppuRuutu){
            Ruutu lahtoruutu = getRuutu(lahto[0],lahto[1]);
            Ruutu loppuruutu = getRuutu(loppu[0],loppu[1]);
            boolean omistaja = onkoOmistaja(lahtoruutu,pelaaja);
            boolean joukot   = onkoRiittavastiYksikoita(lahtoruutu, maara); 
            boolean liikkuminen = onkoMahdLiikkua(lahtoruutu,loppuruutu);
            tarkistukset = (omistaja && joukot&& liikkuminen);
        }        
        return tarkistukset;
    }
    
    
    private boolean onkoRuutuOlemassa (int[] naatit) {
        boolean onko = false;
        
        if(naatit[0]<=leveys && naatit[1] <= korkeus) {
            onko=true;
        }
        
        return onko;
    }
    
    
    
    private boolean onkoRiittavastiYksikoita(Ruutu ruutu, int maara) {
        return (ruutu.getYksikot() >= maara);
    }
    
    private boolean onkoOmistaja(Ruutu ruutu, Pelaaja pelaaja) {
        return (ruutu.getOmistaja() == pelaaja);
    }
    
    private boolean onkoMahdLiikkua(Ruutu lruutu, Ruutu kruutu) {
        boolean liikkuuko = false;
        if (Math.abs(lruutu.getX() - kruutu.getX()) <= 1
                && Math.abs(lruutu.getY() - kruutu.getY()) <= 1) {
            liikkuuko = true;
        }
        return liikkuuko;
    }

}
