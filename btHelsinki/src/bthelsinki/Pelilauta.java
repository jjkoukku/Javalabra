package bthelsinki;

import java.util.ArrayList;
import java.lang.Math;

public class Pelilauta {

    private int leveys;
    private int korkeus;
    private Ruutu[][] ruudukko;
    Ruutu virheRuutu= new Ruutu(); // virheruutu joka ei ole pelattava ja ulkona kaikkialta

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
        Ruutu ruutu;
        if ((x <= leveys) && (y <= korkeus) && (x>=1) && (y>=1) ) {
            ruutu = ruudukko[x - 1][y - 1];
        } else {
            ruutu = virheRuutu;
            System.out.println("Viittaus laudan ulkopuoliseen ruutuun");
        }
        return ruutu;
    }

    public Siirto siirtokasky(int[] lahto, int[] kohde, int maara, Pelaaja pelaaja) {
        Siirto siirtotiedot;
        Ruutu lahtoRuutu = this.getRuutu(lahto[0], lahto[1]);
        Ruutu kohdeRuutu = this.getRuutu(kohde[0], kohde[1]);
        
        if (Tarkistukset(lahtoRuutu, kohdeRuutu, pelaaja, maara)) {
            siirtotiedot = new Siirto(lahtoRuutu, kohdeRuutu, maara, pelaaja); // toistaseksi turhatoiminto...
            this.siirra(lahtoRuutu, kohdeRuutu, maara, pelaaja);
        } else {
            siirtotiedot = new Siirto(false);
            System.out.println("Siirto ei ollut laillinen");
        }

        return siirtotiedot;
    }

    private void siirra(Ruutu lahto, Ruutu loppu, int maara, Pelaaja pelaaja) {
        if (pelaaja == loppu.getOmistaja()) { // rauhanomainen siirtyminen
            lahto.setYksikot(lahto.getYksikot() - maara);
            loppu.setYksikot(loppu.getYksikot() + maara);
            System.out.println("Ei taistelua");
        }
        if (pelaaja != loppu.getOmistaja()) { // Ei todellakaan rauhanomainen siirtyminen
            lahto.setYksikot(lahto.getYksikot() - maara); // sotilaat lähtevät
            int[] tulokset;
            tulokset = Taistelu.taistele(maara, loppu.getYksikot()); // sotilaat taistelevat
            loppu.setYksikot(tulokset[1]);                          // puolustajat palaavat
            if (loppu.getYksikot() == 0) {
                loppu.setOmistaja(pelaaja);
                loppu.setYksikot(tulokset[0]);
            } else {
                lahto.setYksikot(lahto.getYksikot() + tulokset[0]);
            }

        }

    }

    private boolean Tarkistukset(Ruutu lahtoRuutu, Ruutu kohdeRuutu, Pelaaja pelaaja, int maara) {
        boolean tarkistukset = false;
        //kriittiset kaatumisen estämiseksi

        if (lahtoRuutu.getPelattava() && kohdeRuutu.getPelattava()) {
            boolean omistaja = onkoOmistaja(lahtoRuutu, pelaaja);
            boolean joukot = onkoRiittavastiYksikoita(lahtoRuutu, maara);
            boolean liikkuminen = onkoMahdLiikkua(lahtoRuutu, kohdeRuutu);
            tarkistukset = (omistaja && joukot && liikkuminen);
        }
        return tarkistukset;
    }

    private boolean onkoRiittavastiYksikoita(Ruutu ruutu, int maara) {
        return (ruutu.getYksikot() >= maara && maara>0);
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
