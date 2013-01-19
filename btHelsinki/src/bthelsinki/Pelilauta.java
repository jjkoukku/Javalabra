package bthelsinki;

import java.util.ArrayList;

public class Pelilauta {

    private int leveys;
    private int korkeus;
    private ArrayList<Ruutu> ruudukko = new ArrayList<Ruutu>();

    public Pelilauta(int leveys, int korkeus) {

        this.leveys = leveys;
        this.korkeus = korkeus;
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                ruudukko.add(new Ruutu(i, j));
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
        return ruudukko.get(this.naatitJarjluvuks(x, y));
    }

    public void siirto(Ruutu lahto, Ruutu loppu, int maara, Pelaaja pelaaja) {
        if (lahto.getOmistaja() == pelaaja && lahto.getYksikot() >= maara
                && loppu.getOmistaja() == pelaaja) {
            lahto.setYksikot(lahto.getYksikot() - maara);
            loppu.setYksikot(loppu.getYksikot()+ maara);
        }
                if (lahto.getOmistaja() == pelaaja && lahto.getYksikot() >= maara
                && loppu.getOmistaja() != pelaaja) {
            lahto.setYksikot(lahto.getYksikot() - maara);
            loppu.setYksikot(maara);
            loppu.setOmistaja(pelaaja);
        }
                else{ 
                }
    }

    private int naatitJarjluvuks(int x, int y) { // sisainen metodi, palauttaa x,y koordinaatit
        int luku = (y - 1) * this.leveys + x - 1;        // ruudukon järjestyslukuna ylävasemmalta lukien. Esim
        // 3x3 ruudukossa 1 2 3
        //                4 5 6
        //                7 8 9
        return luku;
    }
}
