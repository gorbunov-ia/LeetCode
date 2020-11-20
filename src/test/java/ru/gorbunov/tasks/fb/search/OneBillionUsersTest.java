package ru.gorbunov.tasks.fb.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneBillionUsersTest {

    private OneBillionUsers component;

    @BeforeEach
    void setUp() {
        component = new OneBillionUsers();
    }

    @Test
    void example1() {
        float[] input = {1.5f};

        int result = component.getBillionUsersDay(input);

        Assertions.assertEquals(52, result);
    }

    @Test
    void example2() {
        float[] input = {1.1f, 1.2f, 1.3f};

        int result = component.getBillionUsersDay(input);

        Assertions.assertEquals(79, result);
    }

    @Test
    void example3() {
        float[] input = {1.01f, 1.02f};

        int result = component.getBillionUsersDay(input);

        Assertions.assertEquals(1047, result);
    }
}