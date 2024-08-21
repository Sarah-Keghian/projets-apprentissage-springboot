package fr.sarke.inj_dependance.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToucheADroiteUSTest {

    @Test
    void print() {
        ToucheADroiteUS t = new ToucheADroiteUS();
        assertEquals("d", t.print());
    }
}