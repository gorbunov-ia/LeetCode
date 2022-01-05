package ru.gorbunov.tasks._0238productofarrayexceptself;

/**
 * 238. Product of Array Except Self
 * <p>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * Constraints:
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int multiply = 1;
        int zeros = 0;
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                zeroIndex = i;
            } else {
                multiply *= nums[i];
            }
        }
        int[] result = new int[nums.length];
        if (zeros > 0) {
            if (zeros == 1) {
                result[zeroIndex] = multiply;
            }
            return result;
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = divide(multiply, nums[i]);
        }
        return result;
    }

    private int divide(int dividend, int divisor) {
        int s1 = (int) Math.signum(dividend);
        int s2 = (int) Math.signum(divisor);
        dividend *= s1;
        divisor *= s2;
        if (divisor == 1) {
            return dividend * s1 * s2;
        }
        int result = 0;
        while (dividend > 0) {
            dividend -= divisor;
            result++;
        }
        return result * s1 * s2;
    }

    /*
     * The product is left*right.
     * Example: [2, 3, 4, 5]
     * Numbers:     2    3    4     5
     * Lefts:       1    2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5     1
     */
    public int[] fastProductExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            //left
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}
