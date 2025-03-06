package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter {
    private VuePuits vuePuits;
    private Puits puits;

    private Integer derniereColonneSurvolee = null;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        puits = vuePuits.getPuits();
    }

    public void mouseMoved(MouseEvent event) {
        if (puits.getPieceActuelle() != null) {            
            int colonneSurvolee = event.getX() / vuePuits.getTaille();
            if (derniereColonneSurvolee == null || colonneSurvolee != derniereColonneSurvolee) {
                Piece piece = puits.getPieceActuelle();
                int colonneActuelle = piece.getElements()[0].getCoordonnees().getAbscisse();
                piece.deplacerDe(colonneSurvolee - colonneActuelle, 0);
                derniereColonneSurvolee = colonneSurvolee;
            }
        }
        vuePuits.repaint();
    }
}
