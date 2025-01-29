package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

public class PuitsTest {
    @Test
    public void testSetPieceSuivante() {
        Puits puits = new Puits();
        assertNull(puits.getPieceActuelle());
        assertNull(puits.getPieceSuivante());

        Piece pieceA = new OTetromino(new Coordonnees(0, 0), Couleur.BLEU);
        puits.setPieceSuivante(pieceA);
        assertNull(puits.getPieceActuelle());
        assertEquals(pieceA, puits.getPieceSuivante());

        Piece pieceB = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        puits.setPieceSuivante(pieceB);
        assertEquals(pieceA, puits.getPieceActuelle());
        assertEquals(pieceB, puits.getPieceSuivante());
    }

    @Test
    public void testToString() {
        Puits puits = new Puits();
        puits.setPieceSuivante(new ITetromino(new Coordonnees(7, 8), Couleur.ROUGE));

        assertEquals("Puits : Dimension 10 x 15\n"
                    + "Piece Actuelle : <aucune>\n"
                    + "Piece Suivante : ITetromino :\n"
                    + "\t(7, 8) - ROUGE\n"
                    + "\t(7, 9) - ROUGE\n"
                    + "\t(7, 6) - ROUGE\n"
                    + "\t(7, 7) - ROUGE", puits.toString());
    }
}
