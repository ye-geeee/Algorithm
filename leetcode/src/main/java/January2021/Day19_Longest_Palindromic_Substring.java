package January2021;

public class Day19_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println(new Day19_Longest_Palindromic_Substring.Solution().longestPalindrome("babad"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) return "";

            String res = String.valueOf(s.charAt(0));
            int front;
            int end;

            for (int i = 1; i < s.length(); i++) {
                front = i - 1;
                end = i;
                if (front >= 0 && s.charAt(end) == s.charAt(front)) {

                    while (front - 1 >= 0 && end + 1 < s.length() && s.charAt(front - 1) == s.charAt(end + 1)) {
                        front--;
                        end++;
                    }

                    res = res.length() > s.substring(front, end).length() ?
                            res :
                            s.substring(front, end + 1);
                }

                front = i - 1;
                end = i + 1;

                if (front >= 0 && end < s.length() && s.charAt(front) == s.charAt(end)) {

                    while (front - 1 >= 0 && end + 1 < s.length() && s.charAt(front - 1) == s.charAt(end + 1)) {
                        front--;
                        end++;
                    }

                    res = res.length() > s.substring(front, end).length() ?
                            res :
                            s.substring(front, end + 1);
                }
            }

            return res;
        }
    }
}
