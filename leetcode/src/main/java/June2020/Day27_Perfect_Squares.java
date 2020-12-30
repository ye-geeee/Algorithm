package June2020;

public class Day27_Perfect_Squares {
    public static void main(String[] args) {
        int tc = 13;

        Day27_Perfect_Squares.Solution sol = new Day27_Perfect_Squares().new Solution();
        System.out.println(sol.numSquares(tc));
    }

    class Solution {
        public int numSquares(int n) {

            int maxRoot = 1;
            while (maxRoot * maxRoot <= n) maxRoot++;
            maxRoot--;

            int[][] res = new int[maxRoot + 1][n + 1];

            // Initiate DP arr
            for (int i = 1; i < n + 1; i++)
                res[1][i] = i;

            for (int i = 2; i < maxRoot + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    res[i][j] = res[i - 1][j];
                    if ((j - (i * i)) >= 0) {
                        res[i][j] = Math.min(res[i - 1][j], res[i][j - (i * i)] + 1);
                    }
                }
            }

            return res[maxRoot][n];
        }
    }
}

