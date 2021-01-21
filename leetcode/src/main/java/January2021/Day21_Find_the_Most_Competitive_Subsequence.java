package January2021;

public class Day21_Find_the_Most_Competitive_Subsequence {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6};
        int k = 2;

        System.out.println(new Day21_Find_the_Most_Competitive_Subsequence.Solution().mostCompetitive(nums, k));
    }

    static class Solution {

        public int[] mostCompetitive(int[] nums, int k) {
            if (k == 0) return null;
            if (nums.length == 0) return null;

            int[] stack = new int[nums.length];
            int top = 0;
            stack[top++] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                while (top != 0 && stack[(top - 1)] > nums[i] && (top + nums.length - i) > k) {
                    top--;
                }
                if (top < k)
                    stack[top++] = nums[i];
            }

            int[] res = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                res[i] = stack[--top];
            }

            return res;
        }
    }
}
