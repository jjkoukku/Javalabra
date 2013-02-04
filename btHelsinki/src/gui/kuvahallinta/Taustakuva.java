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
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
 
    public Taustakuva() {
       try {
           img = ImageIO.read(new File("kuvat/Helsinki.jpg"));
       } catch (IOException e) {
       }
 
    }
 
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    } 
    
    public Image getImg(){
    return img;
    }
    
}