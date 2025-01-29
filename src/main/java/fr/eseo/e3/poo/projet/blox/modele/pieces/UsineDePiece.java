package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import java.util.Random;

/**
 * Probablement un design factory.
 * Permet de construire des pieces.
 */
public class UsineDePiece {
    public static final int ALEATOIRE_COMPLET = 0;
    public static final int ALEATOIRE_PIECE = 1;
    public static final int CYCLIC = 2;
    
    private static int mode = ALEATOIRE_PIECE;
    private static int cyclicIndex = 0;
    private static final Class<?>[] TETROMINOS = {
        OTetromino.class, ITetromino.class, TTetromino.class, 
        LTetromino.class, JTetromino.class, STetromino.class, ZTetromino.class
    };
    
    private UsineDePiece() {
        // Constructeur privé pour empêcher l'instanciation
    }
    
    public static void setMode(int mode) {
        if (mode == ALEATOIRE_COMPLET || mode == ALEATOIRE_PIECE || mode == CYCLIC) {
            UsineDePiece.mode = mode;
        }
    }

    public static Tetromino genererTetromino() {
        Tetromino piece = null;
        switch (mode) {
            case CYCLIC:
                try {
                    piece = (Tetromino) TETROMINOS[cyclicIndex].getDeclaredConstructor(int.class, int.class)
                            .newInstance(2, 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cyclicIndex = (cyclicIndex + 1) % TETROMINOS.length;
                break;
            case ALEATOIRE_COMPLET:
                piece = Tetromino.genererAleatoire(2, 3);
                break;
            case ALEATOIRE_PIECE:
            default:
                piece = new OTetromino(2, 3);
                break;
        }
        return piece;
    }
}

}


import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;