package fr.eseo.e3.poo.projet.blox.modele;

public class Coordonnees {
    private int abscisse;
    private int ordonnee;

    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setAbscisse(int newAbscisse) {
        abscisse = newAbscisse;
    }

    public void setOrdonnee(int newOrdonnee) {
        ordonnee = newOrdonnee;
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(abscisse) + ", " + String.valueOf(ordonnee) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordonnees) {
            Coordonnees coordonnees = (Coordonnees) obj;
            return coordonnees.getAbscisse() == this.abscisse 
                   && coordonnees.getOrdonnee() == this.ordonnee;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(abscisse + ordonnee).hashCode();
    }
}
