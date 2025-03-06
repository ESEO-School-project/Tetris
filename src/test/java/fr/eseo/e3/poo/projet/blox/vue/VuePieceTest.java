package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;

public class VuePieceTest {

    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new VuePiece(
            new ITetromino(new Coordonnees(1, 5), Couleur.BLEU),
            50
            )
        );
    }

    @Test
    public void testTeinte() {
        Color color = Color.MAGENTA;
        Color colorTeinte = VuePiece.teinte(color);
        assertNotEquals(color, colorTeinte);
        assertEquals(colorTeinte.getRed(), (int) ((255 - color.getRed()) * VuePiece.MULTIPLIER_TEINTE));
        assertEquals(colorTeinte.getGreen(), (int) ((255 - color.getGreen()) * VuePiece.MULTIPLIER_TEINTE));
        assertEquals(colorTeinte.getBlue(), (int) ((255 - color.getBlue()) * VuePiece.MULTIPLIER_TEINTE));
    }

    @Test
    public void testAfficherPiece() {
        assertDoesNotThrow(() -> new VuePiece(null, 0).afficherPiece(null));
    }
}
