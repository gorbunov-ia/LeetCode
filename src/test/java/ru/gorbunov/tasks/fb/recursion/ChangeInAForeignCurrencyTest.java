package ru.gorbunov.tasks.fb.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChangeInAForeignCurrencyTest {

    private ChangeInAForeignCurrency component;

    @BeforeEach
    void setUp() {
        component = new ChangeInAForeignCurrency();
    }

    @Test
    void example1() {
        int targetMoney = 94;
        int[] denominations = new int[]{5, 10, 25, 100, 200};

        boolean result = component.canGetExactChange(targetMoney, denominations);

        Assertions.assertFalse(result);
    }

    @Test
    void example2() {
        int targetMoney = 75;
        int[] denominations = new int[]{4, 17, 29};

        boolean result = component.canGetExactChange(targetMoney, denominations);

        Assertions.assertTrue(result);
    }
}