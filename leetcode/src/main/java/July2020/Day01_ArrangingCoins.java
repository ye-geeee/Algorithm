package July2020;

public class Day01_ArrangingCoins {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.arrangeCoins(1804289383));
    }

    static class Solution {
        public int arrangeCoins(final int n) {
            return (int) (-1 + Math.sqrt(1 + (long) 8 * n)) / 2;
        }
    }
}
