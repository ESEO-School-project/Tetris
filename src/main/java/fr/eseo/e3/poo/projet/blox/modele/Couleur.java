package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

public enum Couleur {
    ROUGE(Color.RED),
    ORANGE(new Color(255, 200, 0)), // ORANGE spécifique (Java `Color.ORANGE` = (255, 165, 0))
    BLEU(Color.BLUE),
    VERT(Color.GREEN),
    JAUNE(Color.YELLOW),
    CYAN(Color.CYAN),
    VIOLET(Color.MAGENTA),
    BLANC(Color.WHITE);

    private final Color couleurPourAffichage;

    private Couleur(Color couleurPourAffichage) {
        this.couleurPourAffichage = couleurPourAffichage;
    }

    public Color getCouleurPourAffichage() {
        return couleurPourAffichage;
    }
}