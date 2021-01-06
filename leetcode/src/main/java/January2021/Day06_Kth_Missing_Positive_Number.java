package January2021;

public class Day06_Kth_Missing_Positive_Number {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 2;
        System.out.println(new Day06_Kth_Missing_Positive_Number.Solution().findKthPositive(arr, k));
    }

    static class Solution {
        public int findKthPositive(int[] arr, int k) {
            int res = 0;
            int idx = 0;

            while (idx < arr.length && k != 0) {
                res++;
                if (res == arr[idx]) {
                    idx++;

                } else {
                    k--;
                }
            }

            return res + k;
        }
    }
}
