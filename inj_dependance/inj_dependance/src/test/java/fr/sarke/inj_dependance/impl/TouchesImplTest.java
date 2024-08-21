package fr.sarke.inj_dependance.impl;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TouchesImplTest {

    @Test
    void print() {
        TouchesImpl touches = new TouchesImpl(new ToucheAvancerUS(), new ToucheAGaucheUS(), new ToucheReculerUS(), new ToucheADroiteUS());
        assertEquals("z, q, s, d", touches.print());
    }
}