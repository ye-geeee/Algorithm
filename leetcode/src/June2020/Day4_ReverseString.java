package src.June2020;

public class Day4_ReverseString {

    public static void main(String[] args) {
        char[] tc = new char[5];
        tc[0] = 'h';
        tc[1] = 'e';
        tc[2] = 'l';
        tc[3] = 'l';
        tc[4] = 'o';
        Solution sol = new Day4_ReverseString().new Solution();
        sol.reverseString(tc);
        System.out.println(tc);
    }

    class Solution {
        public void reverseString(char[] s) {
            for (int i = 0; i < s.length / 2; i++) {
                char temp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = temp;
            }
        }
    }
}