package fr.eseo.e3.poo.projet.blox;

import javax.swing.*;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class IhmTest extends JFrame {
    private static Puits puits;
    private static VuePuits vuePuits;

    public IhmTest() {
        puits = new Puits();
        vuePuits = new VuePuits(puits);
        puits.addPropertyChangeListener(vuePuits);
        addMouseMotionListener(new PieceDeplacement(vuePuits));

        add(vuePuits);
        testPanneau();
        pack();

        setTitle("Blox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(vuePuits.getPreferredSize());
        setVisible(true);
    }

    public void testPanneau() {
        puits.setPieceSuivante(new ITetromino(new Coordonnees(0, 0), Couleur.ROUGE));
        puits.setPieceSuivante(new ITetromino(new Coordonnees(0, 0), Couleur.BLEU));
    };

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                IhmTest main = new IhmTest();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
