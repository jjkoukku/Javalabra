package bthelsinki;

public class Siirto {
    private boolean onnistuko = true;
    
    public Siirto(Ruutu lahto, Ruutu loppu, int maara, Pelaaja pelaaja){
        
    }
    public Siirto(boolean eiToimi){
        onnistuko = false;
    }
    
    public boolean Onnistuko(){
        return onnistuko;
    }
}