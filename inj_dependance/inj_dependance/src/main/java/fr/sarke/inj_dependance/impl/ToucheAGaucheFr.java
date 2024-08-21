package fr.sarke.inj_dependance.impl;

import fr.sarke.inj_dependance.ToucheAGauche;

public class ToucheAGaucheFr implements ToucheAGauche {
    static String value = "a";

    public String print(){
        return value;
    }
}
