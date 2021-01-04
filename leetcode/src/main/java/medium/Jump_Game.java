package medium;

public class Jump_Game {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Jump_Game.Solution().canJump(nums));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i > max) return false;
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) return true;
            }

            return true;
        }
    }
}
