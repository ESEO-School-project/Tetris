package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ElementTest {
    @Test
    public void testToString() {
        assertEquals("(1, 2) - ROUGE", new Element(1, 2, Couleur.ROUGE).toString());
    }

    @Test
    public void testEquals() {
        Element elA = new Element(1, 2, Couleur.BLEU);
        Element elB = new Element(1, 2, Couleur.BLEU);
        Element elC = new Element(1, 2, Couleur.CYAN);
        Element elD = new Element(2, 1, Couleur.CYAN);
        Element elE = new Element(2, 2, Couleur.CYAN);

        assertTrue(elA.equals(elB));
        assertFalse(elA.equals(elC));
        assertFalse(elA.equals(elD));
        assertFalse(elA.equals(elE));
    }

    @Test
    public void testHashCode() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        assertEquals(coordonnees.hashCode() + couleur.hashCode(), new Element(coordonnees, couleur).hashCode());
    }
}
