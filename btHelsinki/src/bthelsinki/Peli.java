/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bthelsinki;


public class Peli {

    private Pelilauta pelilauta;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja vuorossaOleva;
    private Ruutu hqRuutuP1; //päämaja- ja aloitusruudut
    private Ruutu hqRuutuP2;
    private boolean peliLoppu = false;
    private Pelaaja voittaja;
    
    private int kiintJoukLisys= 9;  // ie. paljon saa riippumatta ruutujen määrästä
    private int ruudJoukLisays=1;   // paljon jokainen ruutu tuo lisää yksikköjä / vuoro

    /**
     * 
     * @param pelilauta Annetaan pelilautaluokan olio
     * @param pelaaja1  pelaaja luokan olio, 1. pelaaja pelissä
     * @param pelaaja2  pelaaja luokan olio; 2. pelaaja pelissä
     */
    
    public Peli(Pelilauta pelilauta, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelilauta = pelilauta;
        this.pelaaja1 = pelaaja1;
        vuorossaOleva = pelaaja1;
        this.pelaaja2 = pelaaja2;
        hqRuutuP1 = pelilauta.getRuutu(1, 1); //aloitusruudut vastakkaisissa reunoissa.
        hqRuutuP2 = pelilauta.getRuutu(pelilauta.getLeveys(), pelilauta.getKorkeus());
        
        hqRuutuP1.setYksikot(10);
        hqRuutuP1.setOmistaja(pelaaja1);
        hqRuutuP1.setHq(); // ruutu tietää, onko hq
        pelaaja1.setHq(hqRuutuP1); // pelaaja tietää onko hq
        
        hqRuutuP2.setYksikot(10);
        hqRuutuP2.setOmistaja(pelaaja2);
        hqRuutuP2.setHq();
        pelaaja2.setHq(hqRuutuP2);
        
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    public Pelaaja getvuorossaOleva(){
        return vuorossaOleva;
    }
  /**
   * Lopettaa vuoron, jolloin metodi getVuorossaoleva palauttaa eri pelaajan kuin ennen tätä
   */
    public void lopetaVuoro(){
        if (vuorossaOleva == pelaaja1){
            vuorossaOleva = pelaaja2;
        }
        else {
            vuorossaOleva = pelaaja1;
        }
        this.lisaaYksikoita(vuorossaOleva);
    }
    
    /**
     * 
     * @param lahto Lähtöruudun koordinaattit: muotoa [x,y] jossa x,y ovat koordinaatteja
     * @param kohde Kohderuudun koordinaattit: muotoa [x,y] jossa x,y ovat koordinaatteja
     * @param maara Siirrettävien yksiköiden määrä
     * @return 
     */
    
    public Siirto siirra(int[] lahto, int[] kohde, int maara) {             
        Siirto siirtotiedot = pelilauta.siirtokasky(lahto, kohde, maara, vuorossaOleva);
        return siirtotiedot;
    }

    private void lisaaYksikoita(Pelaaja pelaaja){
        pelilauta.luoYksikoita(pelaaja.getHq(), getYksikkoTuotanto(pelaaja));
    }
    
    public int getYksikkoTuotanto(Pelaaja pelaaja){
        return kiintJoukLisys + pelilauta.omistettavatRuudutLkm(pelaaja)*ruudJoukLisays;
    }
/**
 * 
 * @return palauttaa boolean muuttujan True, jos peli on ohi, eli toinen pelaajista on saavuttanut tosien pelaajan HQ:n
 */
    public boolean onkoPeliOhi(){
        this.peliLoppu = true;
        if(hqRuutuP1.getOmistaja()==pelaaja1 
                && hqRuutuP2.getOmistaja()==pelaaja2) {
            peliLoppu = false;
        }
        if(peliLoppu && this.getVoittaja()==null){
            this.voittaja = this.vuorossaOleva;
        }
        return peliLoppu;
    }
    
    public Pelaaja getVoittaja(){
        return voittaja;    
    }
    
}
