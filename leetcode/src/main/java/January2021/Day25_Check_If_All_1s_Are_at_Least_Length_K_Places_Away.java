package January2021;

public class Day25_Check_If_All_1s_Are_at_Least_Length_K_Places_Away {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 0, 1};
        int k = 2;
        System.out.println(new Day25_Check_If_All_1s_Are_at_Least_Length_K_Places_Away.Solution().kLengthApart(nums, k));
    }

    static class Solution {
        public boolean kLengthApart(int[] nums, int k) {

            int prevIdx = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    if (prevIdx != -1) {
                        if (i - prevIdx < k + 1) return false;
                    }
                    prevIdx = i;
                }
            }

            return true;
        }
    }
}
