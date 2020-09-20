package ru.gorbunov.tasks._0049groupanagrams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groups = solution.groupAnagrams(strs);

        Assertions.assertEquals(3, groups.size());
        assertContains(groups, "bat");
        assertContains(groups, "nat", "tan");
        assertContains(groups, "ate", "eat", "tea");
    }

    @Test
    void example2() {
        String[] strs = {""};

        List<List<String>> groups = solution.groupAnagrams(strs);

        Assertions.assertEquals(1, groups.size());
        assertContains(groups, "");
    }

    @Test
    void example3() {
        String[] strs = {"a"};

        List<List<String>> groups = solution.groupAnagrams(strs);

        Assertions.assertEquals(1, groups.size());
        assertContains(groups, "a");
    }

    private void assertContains(List<List<String>> groups, String... values) {
        Set<String> set = new HashSet<>(Arrays.asList(values));
        for (List<String> group : groups) {
            if (group.size() == set.size() && set.containsAll(group)) {
                return;
            }
        }
        Assertions.fail();
    }
}