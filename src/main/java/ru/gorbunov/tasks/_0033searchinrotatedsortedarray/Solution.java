package ru.gorbunov.tasks._0033searchinrotatedsortedarray;

/**
 * Search in Rotated Sorted Array
 * <p>
 * Given an integer array nums sorted in ascending order, and an integer target.
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You should search for target in nums and if you found return its index, otherwise return -1.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length <= 1 || nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, 0, nums.length, target);
        }
        int index = findRotatedIndex(nums, 0, nums.length - 1);
        if (target >= nums[0] && target <= nums[index - 1]) {
            return binarySearch(nums, 0, index, target);
        }
        if (target >= nums[index] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, index, nums.length , target);
        }
        return -1;
    }

    private int findRotatedIndex(int[] nums, int left, int right) {
        if (nums[left] >= nums[right] && left + 1 == right) {
            return right;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > nums[right]) {
            return findRotatedIndex(nums, mid, right);
        } else {
            return findRotatedIndex(nums, left, mid);
        }
    }

    private int binarySearch(int[] nums, int from, int to, int target) {
        while (from < to) {
            int mid = (from + to) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }
        return -1;
    }

    int newSearch(int[] nums, int target) {
        return doNewSearch(nums, nums.length, target);
    }

    int doNewSearch(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}
