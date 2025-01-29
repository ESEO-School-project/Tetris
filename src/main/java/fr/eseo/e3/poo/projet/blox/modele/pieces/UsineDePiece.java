package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

/**
 * Probablement un design factory.
 * Permet de construire des pieces.
 */
public class UsineDePiece {
    public static Mode mode = UsineDePiece.Mode.ALEATOIRE_PIECE;
    // FIXME: c'est pas super super :(
    public static String[] tetrominos = {"ITetromino", "OTetromino"};

    private static int counter = 0;

    private UsineDePiece() {
        throw new UnsupportedOperationException("Cette classe ne peut pas être instanciée");
    }

    public static void setMode(Mode mode) {
        UsineDePiece.mode = mode;
    }

    // FIXME: c'est pas super super :(
    private static Tetromino genererTetromino(int index, Coordonnees coordonnees, Couleur couleur) {
        switch (tetrominos[index]) {
            case "ITetromino":
                return new ITetromino(coordonnees, couleur);
            case "OTetromino":
                return new OTetromino(coordonnees, couleur);
            default:
                return null;
        }
    }

    public static Tetromino genererTetromino() {
        Coordonnees defaultCoord = new Coordonnees(2, 3);
        Couleur defaultColor = Couleur.VERT;
        switch (mode) {
            case ALEATOIRE_COMPLET:
                Couleur[] couleurs = Couleur.values();
                Couleur couleur = couleurs[(int) (Math.random() * couleurs.length)];
                return genererTetromino((int) (Math.random() * tetrominos.length), defaultCoord, couleur);
            case ALEATOIRE_PIECE:
                return genererTetromino((int) (Math.random() * tetrominos.length), defaultCoord, defaultColor);
            case CYCLIC:
                counter = counter%tetrominos.length;
                return genererTetromino(counter++, defaultCoord, defaultColor);
            default:
                throw new IllegalArgumentException("La valeur " + mode + " n'est pas supporté");
        }
    }

    public enum Mode {
        ALEATOIRE_COMPLET,
        ALEATOIRE_PIECE,
        CYCLIC
    }
}
