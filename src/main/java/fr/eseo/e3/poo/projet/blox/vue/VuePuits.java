package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuits extends JPanel {
    public static final int TAILLE_PAR_DEFAUT = 720;

    private Puits puits;
    private int taille;
    
    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;

        this.puits.setLargeur(taille);
        this.puits.setProfondeur(taille);
        setPreferredSize(new Dimension(taille, taille));
        setBackground(Color.WHITE);
    }

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return taille;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D) g.create();
        g2D.dispose();
    }
}
