package src.June2020;

public class Day7_Coin_Change_2 {
    public static void main(String[] args) {
        int[] tc = {1, 2, 5};

        Day7_Coin_Change_2.Solution sol = new Day7_Coin_Change_2().new Solution();
        System.out.println(sol.change(5, tc));
    }

    class Solution {
        public int[][] result;

        public int change(int amount, int[] coins) {
            result = new int[coins.length + 1][amount + 1];

            for (int i = 0; i <= coins.length; i++) {
                result[i][0] = 1;
            }

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    result[i][j] += result[i - 1][j];
                    if (j - coins[i - 1] >= 0) result[i][j] += result[i][j - coins[i - 1]];
                }
            }

            return result[coins.length][amount];
        }
    }
}
