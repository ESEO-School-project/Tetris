package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

/**
 * Probablement un design factory.
 * Permet de construire des pieces.
 */
public class UsineDePiece {
    public static final int ALEATOIRE_COMPLET = 1;
    public static final int ALEATOIRE_PIECE = 2;
    public static final int CYCLIC = 3;

    public static int mode = 2;

    private UsineDePiece() {
        throw new UnsupportedOperationException("Cette classe ne peut pas être instanciée");
    }

    public static void setMode(int mode) {
        if (mode < ALEATOIRE_COMPLET || mode > CYCLIC)
            throw new IllegalArgumentException();
        UsineDePiece.mode = mode;
    }

    public static Tetromino genererTetromino() {
        return null;
    }
}
