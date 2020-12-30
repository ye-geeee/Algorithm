public class Day8_Power_Of_Two {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n < 1) return false;
            return (n & (n-1)) == 0;
        }
    }

    public static void main(String[] args) {
        int tc = 218;

        Day8_Power_Of_Two.Solution sol = new Day8_Power_Of_Two().new Solution();
        System.out.println(sol.isPowerOfTwo(tc));
    }
}

