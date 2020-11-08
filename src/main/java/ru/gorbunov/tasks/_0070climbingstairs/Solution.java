package ru.gorbunov.tasks._0070climbingstairs;

/**
 * Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * Constraints:
 * 1 <= n <= 45
 */
public class Solution {

    public int climbStairs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        }
        int step1 = 2;
        int step2 = 1;
        for (int i = 2; i < n; i++) {
            int nextStep = step1 + step2;
            step2 = step1;
            step1 = nextStep;
        }
        return step1;
    }

    /**
     * Solution via formula
     * Fibonacci
     * F_n = [Fi^n - Psi^n] / 5^(1/2), where Fi = [1 + 5^(1/2)] / 2, Psi = [1 - 5^(1/2)] / 2 = 1 - Fi
     * or F_n = floor[Fi^n / 5^(1/2) + 1/2], for n >= 0
     */
    public int fastClimbStairs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        n++; //Task starts from F(1) instead of F(0)
        double root5 = Math.pow(5, 0.5);
//        double result = 1 / root5 * (Math.pow((1 + root5) / 2, n) - Math.pow((1 - root5) / 2, n));
        double fi = (1 + root5) / 2;
        double result = Math.pow(fi, n) / root5 + 0.5d;
        return (int) (result);
    }
}
