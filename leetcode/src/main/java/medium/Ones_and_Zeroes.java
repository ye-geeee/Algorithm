package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Ones_and_Zeroes {
    static class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];

            for (String str : strs) {
                int zeros = 0, ones = 0;
                for (char c : str.toCharArray()) {
                    if (c == '0') zeros++;
                    if (c == '1') ones++;
                }

                for (int i = m; i >= zeros; i--) {
                    for (int j = n; j >= ones; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        String[] strs = {"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"};
        System.out.println(new Solution().findMaxForm(strs, 44, 39));
    }
}
