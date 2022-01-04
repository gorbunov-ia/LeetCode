package ru.gorbunov.tasks._0189rotatearray;

/**
 * 189. Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * Follow up:
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    //[1,2,3,4,5,6], k = 2
    //[6,5,4,3,2,1] r1
    //[5,6,4,3,2,1] r2
    //[5,6,1,2,3,4] r3

    public void gcdRotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;

        //gcd path to finish movie
        for (int i = 0; i < gcd; i++) {
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for (int j = 0; j < count; j++) {
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }

    public int findGcd(int a, int b) {
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }

    public void easyRotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        int[] tmp = new int[step];
        for(int i = 0; i < step; i++){
            tmp[i] = nums[nums.length - step + i];
        }
        for(int i = nums.length - step - 1; i >= 0; i--){
            nums[i + step] = nums[i];
        }
        for(int i = 0; i < step; i++){
            nums[i] = tmp[i];
        }
    }
}
