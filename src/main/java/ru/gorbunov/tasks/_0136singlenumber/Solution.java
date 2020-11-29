package ru.gorbunov.tasks._0136singlenumber;

/**
 * Single Number
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class Solution {

    public int singleNumber(int[] nums) {
        boolean[] sum = new boolean[10];
        for (int num : nums) {
//            final String binaryString = Integer.toBinaryString(num);
//            for (int i = 0; i < binaryString.length(); i++) {
//                sum[sum.length - 1 - i] = sum[sum.length - 1 - i] ^ (binaryString.charAt(binaryString.length() - 1 - i) == '1');
//            }
            boolean[] numBits = toBinary(num);
            for (int i = 0; i < numBits.length; i++) {
                sum[sum.length - 1 - i] = sum[sum.length - 1 - i] ^ numBits[numBits.length - 1 - i];
            }
        }
        StringBuilder sb = new StringBuilder(10);
        for (boolean b : sum) {
            sb.append(b ? '1' : '0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    private boolean[] toBinary(int number) {
        boolean[] result = new boolean[10];
        int currentBit = 0;
        while (number > 0) {
            boolean bit = (number % 2) == 1;
            result[result.length - 1 - currentBit] = bit;
            number /= 2;
            currentBit++;
        }
        return result;
    }

    public int clearSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
