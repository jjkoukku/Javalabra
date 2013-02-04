package bthelsinki;

public class Siirto {
    private boolean onnistuko = true;
    
    public Siirto(Ruutu lahto, Ruutu loppu, int maara, Pelaaja pelaaja){
        
    }
    /**
     * Luodaan jos siirto ei ollut laillinen ja ei aiheuttanut muutoksia laudalla
     * @param eiToimi 
     */
    public Siirto(boolean eiToimi){
        onnistuko = false;
    }

    public boolean getOnnistuko(){
        return onnistuko;
    }
}