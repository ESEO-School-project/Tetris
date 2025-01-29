package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Contient un ensemble d'{@code Element}
 */
public class Tas {
    private List<Element> elements;
    private Puits puits;

    public Tas(Puits puits) {
        this.elements = new ArrayList<>();
        this.puits = puits;
    }
}
