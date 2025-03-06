package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece {
    protected Element[] elements;
    private Puits puits;

    protected Tetromino(Coordonnees coordonnees, Couleur couleur) {
        elements = new Element[4];
        setElements(coordonnees, couleur);
    }

    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    public Element[] getElements() {
        return elements;
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void setPosition(int abscisse, int ordonnee) {
        for (Element element : elements) {
            Coordonnees coord = element.getCoordonnees();
            element.setCoordonnees(new Coordonnees(coord.getAbscisse() + abscisse, coord.getOrdonnee() + ordonnee));
        }
    }

    public void deplacerDe(int deltaX, int deltaY) {
        setPosition(deltaX, deltaY);
    }

    @Override
    public String toString() {
        String string = getClass().getSimpleName() + " :\n";
        for (int i = 0 ; i < elements.length - 1 ; i++)
            string += "\t" + elements[i].toString() + "\n";
        return string + "\t" + elements[elements.length - 1];
    }
}
