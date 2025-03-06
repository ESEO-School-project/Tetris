package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CouleurTest {

    @ParameterizedTest
    @CsvSource({
        "ROUGE, 255, 0, 0",
        "ORANGE, 255, 200, 0",
        "BLEU, 0, 0, 255",
        "VERT, 0, 255, 0",
        "JAUNE, 255, 255, 0",
        "CYAN, 0, 255, 255",
        "VIOLET, 255, 0, 255"
    })
    public void testCouleurs(String couleur, int r, int g, int b) {
        Color color = Couleur.valueOf(couleur).getCouleurPourAffichage();
        assertEquals(new Color(r, g, b), color);
    }
}