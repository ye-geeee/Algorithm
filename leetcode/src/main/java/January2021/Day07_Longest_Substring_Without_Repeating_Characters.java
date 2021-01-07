package January2021;

import java.util.HashMap;

public class Day07_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Day07_Longest_Substring_Without_Repeating_Characters.Solution().lengthOfLongestSubstring(s));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.equals("")) return 0;
            HashMap<Character, Integer> indexMap = new HashMap<>();
            int[] maxLen = new int[s.length()];
            int resetIdx = 0;

            indexMap.put(s.charAt(0), 0);
            maxLen[0] = 1;

            for (int i = 1; i < s.length(); i++) {
                if (indexMap.containsKey(s.charAt(i)) &&
                        indexMap.get(s.charAt(i)) >= resetIdx) {
                    resetIdx = indexMap.get(s.charAt(i));
                    int diff = i - resetIdx;
                    maxLen[i] = diff;
                } else {
                    maxLen[i] = maxLen[i - 1] + 1;
                }
                indexMap.put(s.charAt(i), i);
            }

            int max = 0;
            for (int num : maxLen) {
                max = Math.max(max, num);
            }
            return max;
        }
    }
}
