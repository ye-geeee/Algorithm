package January2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Day22_Determine_if_Two_Strings_Are_Close {
    public static void main(String[] args) {
        String str1 = "cabbba";
        String str2 = "abbccc";
        System.out.println(new Solution().closeStrings(str1, str2));
    }

    static class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) return false;

            int[] word1Size = new int[26];
            int[] word2Size = new int[26];

            for(int i = 0; i < word1.length(); i++) {
                word1Size[word1.charAt(i) - 'a']++;
                word2Size[word2.charAt(i) - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                if (word2Size[i] != 0 && word1Size[i] == 0)
                    return false;
            }

            Arrays.sort(word1Size);
            Arrays.sort(word2Size);

            return Arrays.equals(word1Size, word2Size);
        }
    }
}
