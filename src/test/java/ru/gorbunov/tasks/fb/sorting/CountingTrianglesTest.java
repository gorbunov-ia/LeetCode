package ru.gorbunov.tasks.fb.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.fb.sorting.CountingTriangles.Sides;

import java.util.Arrays;
import java.util.List;

class CountingTrianglesTest {

    private CountingTriangles component;

    @BeforeEach
    void setUp() {
        component = new CountingTriangles();
    }

    @Test
    void example1() {
        List<Sides> input = Arrays.asList(new Sides(2, 2, 3), new Sides(3, 2, 2), new Sides(2, 5, 6));

        int result = component.countDistinctTriangles(input);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example2() {
        List<Sides> input = Arrays.asList(new Sides(8, 4, 6), new Sides(100, 101, 102), new Sides(84, 93, 173));

        int result = component.countDistinctTriangles(input);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example3() {
        List<Sides> input = Arrays.asList(new Sides(5, 8, 9), new Sides(5, 9, 8), new Sides(9, 5, 8),
                new Sides(9, 8, 5), new Sides(8, 9, 5), new Sides(8, 5, 9));

        int result = component.countDistinctTriangles(input);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example4() {
        List<Sides> input = Arrays.asList(new Sides(2, 2, 3), new Sides(3, 3, 2));

        int result = component.countDistinctTriangles(input);

        Assertions.assertEquals(2, result);
    }

}