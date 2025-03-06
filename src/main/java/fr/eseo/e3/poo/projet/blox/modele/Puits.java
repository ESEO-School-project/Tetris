package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

/**
 * Le plateau du jeu
 */
public class Puits {
    public static final int LARGEUR_PAR_DEFAUT = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;
    public static final String MODIFICATION_PIECE_ACTUELLE = "MODIFICATION_PIECE_ACTUELLE";
    public static final String MODIFICATION_PIECE_SUIVANTE = "MODIFICATION_PIECE_SUIVANTE";

    private int largeur;
    private int profondeur;
    private Piece pieceActuelle = null;
    private Piece pieceSuivante = null;

    private PropertyChangeSupport pcs;

    public Puits(int largeur, int profondeur) {
        pcs = new PropertyChangeSupport(this);
        this.largeur = largeur;
        this.profondeur = profondeur;
    }

    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setPieceSuivante(Piece piece) {
        if (pieceSuivante == null) {
            pieceSuivante = piece;
            return;
        }

        pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, pieceActuelle, pieceSuivante);
        pieceActuelle = pieceSuivante;
        pieceActuelle.setPosition((int) largeur/2, (int) largeur/2);
        pieceActuelle.setPuits(this);
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, pieceSuivante, piece);
        pieceSuivante = piece;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    @Override
    public String toString() {
        return "Puits : Dimension " + largeur + " x " + profondeur
               + "\nPiece Actuelle : " + (pieceActuelle == null ? "<aucune>" : pieceActuelle.toString())
               + "\nPiece Suivante : " + pieceSuivante.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
