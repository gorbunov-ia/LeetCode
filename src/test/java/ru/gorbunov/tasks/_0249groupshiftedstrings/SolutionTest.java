package ru.gorbunov.tasks._0249groupshiftedstrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String[] input = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

        List<List<String>> result = solution.groupStrings(input);

        Assertions.assertEquals(4, result.size());
        result.forEach(Collections::sort);
        Assertions.assertTrue(findList(result, Arrays.asList("abc", "bcd", "xyz")));
        Assertions.assertTrue(findList(result, Arrays.asList("az", "ba")));
        Assertions.assertTrue(findList(result, Collections.singletonList("acef")));
        Assertions.assertTrue(findList(result, Arrays.asList("a", "z")));
    }

    @Test
    void example2() {
        String[] input = new String[]{"abc", "bcd"};

        List<List<String>> result = solution.groupStrings(input);

        Assertions.assertEquals(1, result.size());
        result.forEach(Collections::sort);
        Assertions.assertTrue(findList(result, Arrays.asList("abc", "bcd")));
    }

    @Test
    void example3() {
        String[] input = new String[]{"az", "ba"};

        List<List<String>> result = solution.groupStrings(input);

        Assertions.assertEquals(1, result.size());
        result.forEach(Collections::sort);
        Assertions.assertTrue(findList(result, Arrays.asList("az", "ba")));
    }

    @Test
    void example4() {
        String[] input = new String[]{"za", "ab"};

        List<List<String>> result = solution.groupStrings(input);

        Assertions.assertEquals(1, result.size());
        result.forEach(Collections::sort);
        Assertions.assertTrue(findList(result, Arrays.asList("za", "ab")));
    }

    @Test
    void example5() {
        String[] input = new String[]{"aa", "bb", "aa"};

        List<List<String>> result = solution.groupStrings(input);

        Assertions.assertEquals(1, result.size());
        result.forEach(Collections::sort);
        Assertions.assertTrue(findList(result, Arrays.asList("aa", "bb", "aa")));
    }


    private boolean findList(List<List<String>> result, List<String> expected) {
        Collections.sort(expected);
        for (List<String> strings : result) {
            if (expected.equals(strings)) {
                return true;
            }
        }
        return false;
    }
}