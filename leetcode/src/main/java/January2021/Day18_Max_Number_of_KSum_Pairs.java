package January2021;

import java.util.Arrays;

public class Day18_Max_Number_of_KSum_Pairs {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        System.out.println(new Day18_Max_Number_of_KSum_Pairs.Solution().maxOperations(nums, k));
    }

    static class Solution {
        public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);
            int front = 0;
            int end = nums.length - 1;
            int res = 0;

            while (front < end) {
                if ((nums[front] + nums[end]) == k) {
                    front++;
                    end--;
                    res++;
                } else if ((nums[front] + nums[end]) < k) {
                    front++;
                } else {
                    end--;
                }
            }

            return res;
        }
    }
}