package fr.sarke.inj_dependance.impl;

import fr.sarke.inj_dependance.*;

public class TouchesImpl implements AfficheurTouches {

    private ToucheAvancer toucheAvancer;
    private ToucheAGauche toucheAGauche;
    private ToucheADroite toucheADroite;
    private ToucheReculer toucheReculer;

    public TouchesImpl(ToucheAvancer toucheAvancer, ToucheAGauche toucheAGauche, ToucheReculer toucheReculer, ToucheADroite toucheADroite) {
        this.toucheAvancer = toucheAvancer;
        this.toucheAGauche = toucheAGauche;
        this.toucheADroite = toucheADroite;
        this.toucheReculer = toucheReculer;
    }

    public String print(){
        return String.join(", ", toucheAvancer.print(), toucheAGauche.print(), toucheReculer.print(), toucheADroite.print());
    }
}
