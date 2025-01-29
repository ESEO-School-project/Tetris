package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class ITetromino extends Tetromino {
    public ITetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    public void setElements(Coordonnees coordonnees, Couleur couleur) {
        Coordonnees coordBot = new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1);
        Coordonnees coordMid = new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1);
        Coordonnees coordTop = new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 2);

        elements[0] = new Element(coordonnees, couleur);
        elements[1] = new Element(coordBot, couleur);
        elements[2] = new Element(coordMid, couleur);
        elements[3] = new Element(coordTop, couleur);
    }
}
