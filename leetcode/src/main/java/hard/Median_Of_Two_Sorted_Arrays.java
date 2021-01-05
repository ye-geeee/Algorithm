package hard;

import java.util.Arrays;

public class Median_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};

        System.out.println(new Median_Of_Two_Sorted_Arrays.Solution().findMedianSortedArrays(num1, num2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] nums = new int[nums1.length + nums2.length];
            System.arraycopy(nums1, 0, nums, 0, nums1.length);
            System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

            Arrays.sort(nums);
            return (nums.length % 2 == 0) ? (double)(nums[nums.length/2] + nums[nums.length/2 - 1]) / 2 : nums[nums.length / 2];
        }

// Sorting
//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//            int[] nums = new int[nums1.length + nums2.length];
//            System.arraycopy(nums1, 0, nums, 0, nums1.length);
//            System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
//
//            Arrays.sort(nums);
//            return (nums.length % 2 == 0) ? (double)(nums[nums.length/2] + nums[nums.length/2 - 1]) / 2 : nums[nums.length / 2];
//        }
    }
}
