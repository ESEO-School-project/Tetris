package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OTetromino extends Tetromino {
    public OTetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    public void setElements(Coordonnees coordonnees, Couleur couleur) {
        Coordonnees coordTop = new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee());
        Coordonnees coordRight = new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1);
        Coordonnees coordTopRight = new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1);

        elements[0] = new Element(coordonnees, couleur);
        elements[1] = new Element(coordTop, couleur);
        elements[2] = new Element(coordRight, couleur);
        elements[3] = new Element(coordTopRight, couleur);
    }

    public void tourner(boolean sensHoraire) {
        
    }
}
