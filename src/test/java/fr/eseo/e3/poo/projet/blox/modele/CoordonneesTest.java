package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {
    @Test
    public void testConstructor() {
        Coordonnees coordonnees = assertDoesNotThrow(() -> new Coordonnees(1, 2));
        assertEquals(1, coordonnees.getAbscisse());
        assertEquals(2, coordonnees.getOrdonnee());
    }

    @Test
    public void testEquals() {
        Coordonnees coordA = new Coordonnees(1, 1);
        Coordonnees coordB = new Coordonnees(1, 1);
        Coordonnees coordC = new Coordonnees(1, 2);
        Coordonnees coordD = new Coordonnees(2, 1);
        Coordonnees coordE = new Coordonnees(2, 2);

        assertTrue(coordA.equals(coordB));
        assertFalse(coordA.equals(coordC));
        assertFalse(coordA.equals(coordD));
        assertFalse(coordA.equals(coordE));
        assertFalse(coordA.equals(new String()));
    }

    @Test
    public void testHashCode() {
        int abscisse = 1;
        int ordonnee = 2;
        int hashCodeExpected = Integer.valueOf(abscisse + ordonnee).hashCode();
        Coordonnees coord = new Coordonnees(1, 2);

        assertEquals(hashCodeExpected, coord.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("(1, 2)", new Coordonnees(1, 2).toString());
    }
}
