package gui;

import javax.swing.JOptionPane;

public class PIkkuna {

    public static void ilmoita(String viesti) {
        JOptionPane.showMessageDialog(null,
                viesti, "Peli", JOptionPane.PLAIN_MESSAGE);
    }

}