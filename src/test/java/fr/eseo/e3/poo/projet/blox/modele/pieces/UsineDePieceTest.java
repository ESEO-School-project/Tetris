package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece.Mode;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class UsineDePieceTest {
    @Test
    public void testGenererTetromino() {
        // Aleatoire complet
        UsineDePiece.setMode(Mode.ALEATOIRE_COMPLET);
        assertEquals(Mode.ALEATOIRE_COMPLET, UsineDePiece.mode);
        assertFalse(UsineDePiece.genererTetromino().equals(UsineDePiece.genererTetromino()));

        // Aleatoire piece
        UsineDePiece.setMode(Mode.ALEATOIRE_PIECE);
        assertEquals(Mode.ALEATOIRE_PIECE, UsineDePiece.mode);
        Tetromino tetrominoA = UsineDePiece.genererTetromino();
        Tetromino tetrominoB = UsineDePiece.genererTetromino();
        assertFalse(tetrominoA.equals(tetrominoB));
        Element elementOfTetrominoA = tetrominoA.getElements()[0];
        Element elementOfTetrominoB = tetrominoB.getElements()[0];
        assertTrue(elementOfTetrominoA.getCouleur().equals(elementOfTetrominoB.getCouleur()));

        // Cyclic
        UsineDePiece.setMode(Mode.CYCLIC);
        assertEquals(Mode.CYCLIC, UsineDePiece.mode);
        assertInstanceOf(ITetromino.class, UsineDePiece.genererTetromino());
        assertInstanceOf(OTetromino.class, UsineDePiece.genererTetromino());
        // Renvoie une erreur si dans UsineDePiece.tetrominos.length > 2
        assertInstanceOf(ITetromino.class, UsineDePiece.genererTetromino());
    }
}
