package January2021;

public class Day08_Check_If_Two_String_Arrays_are_Equivalent {
    public static void main(String[] args) {
        String[] word1 = {"a", "bc"};
        String[] word2 = {"ab", "c"};
        System.out.println(new Day08_Check_If_Two_String_Arrays_are_Equivalent.Solution().arrayStringsAreEqual(word1, word2));
    }

    static class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String word : word1) {
                sb1.append(word);
            }
            for (String word : word2) {
                sb2.append(word);
            }
            return sb1.toString().equals(sb2.toString());
        }
    }
}