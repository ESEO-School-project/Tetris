package fr.eseo.e3.poo.projet.blox;

import javax.swing.*;
import java.awt.event.*;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.vue.VuePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class IhmTest extends JFrame {
    public IhmTest() {
        super("Blox");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        testPanneau();
    }

    public void testPanneau() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);
        add(vuePuits);
        setSize(vuePuits.getPreferredSize());

        vuePuits.setVuePiece(new VuePiece(new OTetromino(new Coordonnees(2, 2), Couleur.VERT), 50));
        vuePuits.paintComponents(vuePuits.getGraphics());
        vuePuits.setVuePiece(new VuePiece(new ITetromino(new Coordonnees(5, 5), Couleur.BLEU), 50));
        vuePuits.paintComponents(vuePuits.getGraphics());

        setVisible(true);
    };

    public static void main(String[] args) {
        new IhmTest();
    }
}
