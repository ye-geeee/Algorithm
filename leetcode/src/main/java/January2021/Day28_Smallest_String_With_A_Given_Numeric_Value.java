package January2021;

import java.util.Arrays;

public class Day28_Smallest_String_With_A_Given_Numeric_Value {
    public static void main(String[] args) {
        System.out.println(new Solution().getSmallestString(5, 73));
    }

    static class Solution {
        public String getSmallestString(int n, int k) {
            char[] res = new char[n];
            int zLen = (k - n) / 25;
            int notzVal = (k - n) % 25;

            Arrays.fill(res, n - zLen, n, 'z');

            if (zLen < n) {
                Arrays.fill(res, n - zLen - 1, n - zLen, (char)('a' + notzVal));
                Arrays.fill(res, 0, n - zLen - 1, 'a');
            }

            return String.valueOf(res);
        }
    }
}
