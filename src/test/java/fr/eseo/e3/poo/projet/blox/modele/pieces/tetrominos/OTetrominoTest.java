package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OTetrominoTest {
    public static OTetromino oTetromino;

    @BeforeAll
    public static void init() {
        oTetromino = new OTetromino(new Coordonnees(0, 0), Couleur.BLEU);
    }

    @Test
    public void testSetElements() {
        // On a pas besoin de call la fonction setElements car elle est déjà executé par le constructeur de OTetromino
        assertArrayEquals(new Element[] {
            new Element(new Coordonnees(0, 0), Couleur.BLEU),
            new Element(new Coordonnees(1, 0), Couleur.BLEU),
            new Element(new Coordonnees(0, -1), Couleur.BLEU),
            new Element(new Coordonnees(1, -1), Couleur.BLEU)
        }, oTetromino.getElements());
    }

    @Test
    public void testToString() {
        assertEquals("OTetromino :\n\t(0, 0) - BLEU\n\t(1, 0) - BLEU\n\t(0, -1) - BLEU\n\t(1, -1) - BLEU", oTetromino.toString());
    }
}
