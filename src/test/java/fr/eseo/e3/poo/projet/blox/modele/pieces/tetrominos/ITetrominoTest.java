package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class ITetrominoTest {
    @Test
    public void testSetElements() {
        assertArrayEquals(new Element[] {
            new Element(new Coordonnees(0, 0), Couleur.BLEU),
            new Element(new Coordonnees(0, 1), Couleur.BLEU),
            new Element(new Coordonnees(0, -2), Couleur.BLEU),
            new Element(new Coordonnees(0, -1), Couleur.BLEU)
        }, new ITetromino(new Coordonnees(0, 0), Couleur.BLEU).getElements());
    }
}
