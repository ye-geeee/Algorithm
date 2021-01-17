package January2021;

import java.util.Arrays;

public class Day16_Kth_Largest_Element_In_An_Array {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new Day16_Kth_Largest_Element_In_An_Array.Solution().findKthLargest(nums, k));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}
