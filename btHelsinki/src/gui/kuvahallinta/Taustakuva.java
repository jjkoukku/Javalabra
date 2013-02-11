/**
 * Kopioitu oraclen java-tutoriaalista, ei pysy kauaa tässä muodossa.
 */

package gui.kuvahallinta;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 

public class Taustakuva extends Component {
           
    BufferedImage img;
    Dimension koko;
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    

    
    public Taustakuva(Dimension dim) {
       try {
           img = ImageIO.read(new File("kuvat/Helsinki.jpg"));
           this.koko = dim;
       } catch (IOException e) {
       }
 
    }
    public Taustakuva() {
       try {
           img = ImageIO.read(new File("kuvat/Helsinki.jpg"));
       } catch (IOException e) {
       }
    koko = new Dimension(100,100);
    }
    
    public Dimension getPreferredSize() {
       if(this.getSize()==null) {
        return koko;
       }
       else {
        return new Dimension(img.getWidth(),img.getHeight());
    } 
    }
    public Image getImg(){
        return img;
    }
}