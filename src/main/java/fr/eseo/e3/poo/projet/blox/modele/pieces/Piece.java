package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public interface Piece {
    Element[] getElements();
    void setPosition(int abscisse, int ordonnee);
    Puits getPuits();
    void setPuits(Puits puits);
    void deplacerDe(int deltaX, int deltaY);
    void tourner(boolean sensHoraire);
}

