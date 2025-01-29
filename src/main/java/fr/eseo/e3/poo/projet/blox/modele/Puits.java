package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

/**
 * Le plateau du jeu
 */
public class Puits {
    private static final int LARGEUR_PAR_DEFAUT = 10;
    private static final int PROFONDEUR_PAR_DEFAUT = 15;

    private int largeur;
    private int profondeur;
    private Piece pieceActuelle = null;
    private Piece pieceSuivante = null;

    public Puits() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.profondeur = PROFONDEUR_PAR_DEFAUT;
    }

    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
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

        pieceActuelle = pieceSuivante;
        pieceActuelle.setPosition((int) largeur/2, -4);
        pieceActuelle.setPuits(this);
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
}
