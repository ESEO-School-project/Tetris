package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Dimension;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

    @Test
    public void testConstructor() {
        Puits puits = new Puits();
        VuePuits vuePuitsA = assertDoesNotThrow(() -> new VuePuits(puits));
        assertEquals(puits, vuePuitsA.getPuits());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuitsA.getTaille());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuitsA.getPuits().getLargeur());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuitsA.getPuits().getProfondeur());
        assertEquals(new Dimension(VuePuits.TAILLE_PAR_DEFAUT, VuePuits.TAILLE_PAR_DEFAUT), vuePuitsA.getPreferredSize());

        assertDoesNotThrow(() -> new VuePuits(puits, 1));
    }

    @Test
    public void testTaille() {
        VuePuits vuePuitsDefaultSize = new VuePuits(new Puits());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuitsDefaultSize.getTaille());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuitsDefaultSize.getPuits().getLargeur());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuitsDefaultSize.getPuits().getProfondeur());

        int taille = 1080;
        VuePuits vuePuitsSpecifiedSize = new VuePuits(new Puits(), taille);
        assertEquals(taille, vuePuitsSpecifiedSize.getTaille());
        assertEquals(taille, vuePuitsSpecifiedSize.getPuits().getLargeur());
        assertEquals(taille, vuePuitsSpecifiedSize.getPuits().getProfondeur());

        assertEquals(
            new Dimension(VuePuits.TAILLE_PAR_DEFAUT, VuePuits.TAILLE_PAR_DEFAUT),
            new VuePuits(new Puits()).getPreferredSize()
        );
    }

    @Test
    public void testBackgroundColor() {
        VuePuits vuePuits = new VuePuits(new Puits());
        assertEquals(Color.WHITE, vuePuits.getBackground());
    }
}
