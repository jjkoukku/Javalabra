package txtUI;

import java.util.Scanner;
import bthelsinki.Peli;

public class TxtUI {

    private Scanner lukija = new Scanner(System.in);

    public TxtUI() {
    }

    public boolean askAloita() {
        return true;
    }

    public void iVuoronAlku(String pelaaja) {
        System.out.println(pelaaja + " ,sinun vuorosi");
    }

    public void iPelinLoppu() {
        System.out.println("Peli loppui");
    }

    public int[] askKoordinaatit() {
        int[] naatit = new int[2];

        System.out.println("Anna x-koordinaatti");
        naatit[0] = lukija.nextInt();
        System.out.println("Annoit x-koordinaatin " + naatit[0]);

        System.out.println("Anna y-koordinaatti");
        naatit[1] = lukija.nextInt();
        System.out.println("Annoit y-koordinaatin " + naatit[1]);

        return naatit;
    }

    public int askMaara() {
        int maara = 0;

        System.out.println("Anna siirrettavien maara");
        maara = lukija.nextInt();
        System.out.println("Annoit määrän " + maara);
        return maara;
    }
    
    public boolean askLopetatkoVuoron() {
        boolean jatkaako = true;
        System.out.println("Anna 0, jos et halua siirtää");
        if (lukija.nextInt()==0){            
        jatkaako = false;
        }
        return jatkaako;
    }

    public boolean askLopetus() {
        return true;
    }

    public void naytaPelilauta(Peli peli) {
        for (int i = 1; i <= peli.getPelilauta().getKorkeus(); i++) {
            for (int j = 1; j <= peli.getPelilauta().getLeveys(); j++) {
                System.out.print(peli.getPelilauta().getRuutu(j, i));
            }
            System.out.println();
        }
    }
}
