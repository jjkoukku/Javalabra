package bthelsinki;
import java.lang.Math;
        
public class Taistelu {
    
    
    
    public static int[] taistele(int hyok, int puol) {
        double puolBonus = 1.3;
        int[] lopputulos = new int[2];
        int hyokAihVaur = (int)(hyok*Math.random());
        int puolAihVaur = (int)(puol*Math.random()*puolBonus);
        System.out.println("Hyökkääjät tuhosivat " + hyokAihVaur);
        System.out.println("Puolustajat tuhosivat " + puolAihVaur);
        lopputulos[0] = Math.max(hyok-puolAihVaur,0);
        lopputulos[1] = Math.max(puol-hyokAihVaur,0);
        
        return lopputulos;        
    }
}