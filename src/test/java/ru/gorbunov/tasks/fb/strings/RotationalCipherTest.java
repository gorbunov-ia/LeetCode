package ru.gorbunov.tasks.fb.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotationalCipherTest {

    private RotationalCipher component;

    @BeforeEach
    void setUp() {
        component = new RotationalCipher();
    }

    @Test
    void example1() {
        String input = "Zebra-493?";
        int rotationFactor = 3;

        String result = component.rotationalCipher(input, rotationFactor);

        Assertions.assertEquals("Cheud-726?", result);
    }

    @Test
    void example2() {
        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        int rotationFactor = 39;

        String result = component.rotationalCipher(input, rotationFactor);

        Assertions.assertEquals("nopqrstuvwxyzABCDEFGHIJKLM9012345678", result);
    }
}