package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener {
    public static final int TAILLE_PAR_DEFAUT = 25;

    private Puits puits;
    private int taille;

    private VuePiece vuePiece;

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;

        setTaille(taille);
        setBackground(Color.WHITE);
    }

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return taille;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
        repaint();
    }

    public void setTaille(int taille) {
        setPreferredSize(new Dimension(taille * puits.getLargeur(), taille * puits.getProfondeur()));
        this.taille = taille;
    }

    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // Grid display
        g2D.setColor(Color.LIGHT_GRAY);
        for (int l = 0 ; l < puits.getLargeur() ; l++)
            g2D.drawLine(l * taille, 0, l * taille, getHeight());
        for (int p = 0 ; p < puits.getProfondeur() ; p++)
            g2D.drawLine(0, p * taille, getWidth(), p * taille);

        // Piece display
        if (vuePiece != null)
            vuePiece.afficherPiece(g2D);

        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == Puits.MODIFICATION_PIECE_ACTUELLE 
            && evt.getNewValue() instanceof Piece piece)
            setVuePiece(new VuePiece(piece, taille));
    }
}
