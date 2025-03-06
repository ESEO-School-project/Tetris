package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {
    public static final double MULTIPLIER_TEINTE = .234;
    private final Piece piece;
    private final int taille;

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public static Color teinte(Color couleur) {
        return new Color(
            (int) ((255 - couleur.getRed()) * MULTIPLIER_TEINTE),
            (int) ((255 - couleur.getGreen()) * MULTIPLIER_TEINTE),
            (int) ((255 - couleur.getBlue()) * MULTIPLIER_TEINTE)
        );
    }

    public void afficherPiece(Graphics2D g2D) {
        if (piece == null || g2D == null)
            return;

        for (Element element : piece.getElements()) {
            g2D.setColor(element.getCouleur().getCouleurPourAffichage());
            Coordonnees coord = element.getCoordonnees();
            g2D.fill3DRect(coord.getAbscisse() * taille, coord.getOrdonnee() * taille, taille, taille, false);
        }
    }
}
