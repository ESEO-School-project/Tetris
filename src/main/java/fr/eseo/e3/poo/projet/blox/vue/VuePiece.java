package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class VuePiece extends JPanel {
    private static final double FACTOR = 0.7; 
    private final int[][] elements; 
    private final Color couleur;
    private final int tailleBloc = 30; 

    public VuePiece(int[][] elements, Color couleur) {
        this.elements = elements;
        this.couleur = couleur;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < elements.length; i++) {
            int x = elements[i][0] * tailleBloc;
            int y = elements[i][1] * tailleBloc;
            Color couleurPourAffichage = (i == 0) ? brighterCustom(couleur) : couleur; 

            g2d.setColor(couleurPourAffichage);
            g2d.fill3DRect(x, y, tailleBloc, tailleBloc, true);
        }
    }

    private Color brighterCustom(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int alpha = color.getAlpha();
        
        int i = (int) (1.0/(1.0-FACTOR));

        if ( r == 0 && g == 0 && b == 0) {
            return new Color(i, i, i, alpha);
        }

        if ( r > 0 && r < i ) r = i;
        if ( g > 0 && g < i ) g = i;
        if ( b > 0 && b < i ) b = i;

        r = Math.min((int) (r/FACTOR), 255);
        g = Math.min((int) (g/FACTOR), 255);
        b = Math.min((int) (b/FACTOR), 255);

        return new Color(r, g, b, alpha); 
    }
}