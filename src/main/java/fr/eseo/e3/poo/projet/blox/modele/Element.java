package fr.eseo.e3.poo.projet.blox.modele;

public class Element {
    private Couleur couleur;
    private Coordonnees coordonnees;

    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee));
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this(coordonnees);
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this(new Coordonnees(abscisse, ordonnee), couleur);
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCoordonnees(Coordonnees newCoordonnees) {
        coordonnees = newCoordonnees;
    }

    public void setCouleur(Couleur newCouleur) {
        couleur = newCouleur;
    }

    @Override
    public String toString() {
        return coordonnees.toString() + " - " + couleur.name();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Element) {
            Element element = (Element) obj;
            return element.coordonnees.equals(coordonnees) 
                   && element.couleur.equals(couleur);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return coordonnees.hashCode() + couleur.hashCode();
    }

    public void deplacerDe(int deltaX, int deltaY) {
        
    }
}
