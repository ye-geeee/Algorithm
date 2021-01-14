package January2021;

public class Day14_Minimum_Operations_to_Reduce_X_to_Zero {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println(new Day14_Minimum_Operations_to_Reduce_X_to_Zero.Solution().minOperations(nums1, x));

        int[] nums2 = {5, 6, 7, 8};
        x = 4;
        System.out.println(new Day14_Minimum_Operations_to_Reduce_X_to_Zero.Solution().minOperations(nums2, x));
    }

    static class Solution {
        public int minOperations(int[] nums, int x) {
            int i = 0;
            int j = nums.length - 1;

            int res = Integer.MAX_VALUE;
            int tempSum = 0;

            while (i < nums.length && tempSum + nums[i] <= x) {
                tempSum += nums[i++];
            }

            int tempCnt = i;

            while (i >= 0) {
                while (j > i && tempSum + nums[j] <= x) {
                    tempSum += nums[j];
                    tempCnt++;
                    j--;
                }

                res = tempSum == x ? Math.min(res, tempCnt) : res;
                tempSum = --i < 0 ? tempSum : tempSum - nums[i];
                tempCnt -= 1;
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
