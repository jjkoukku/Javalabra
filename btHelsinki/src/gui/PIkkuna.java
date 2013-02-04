package gui;

import javax.swing.JOptionPane;

public class PIkkuna {
    /**
     * Heittää ruutuun Ponnahdusikkuna, jossa on OK-painike.
     * @param viesti Ikkunassa näkyvä viesti
     */
    public static void ilmoita(String viesti) {
        JOptionPane.showMessageDialog(null,
                viesti, "Peli", JOptionPane.PLAIN_MESSAGE);
    }

}