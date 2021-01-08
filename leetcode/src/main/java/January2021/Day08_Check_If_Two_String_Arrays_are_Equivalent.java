public class Day08_Check_If_Two_String_Arrays_are_Equivalent {
    public static void main(String[] args) {
        String[] word1 = {"a", "bc"};
        String[] word2 = {"ab", "c"};
        System.out.println(new Day08_Check_If_Two_String_Arrays_are_Equivalent.Solution().arrayStringsAreEqual(word1, word2));
    }
    static class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            String resWord1 = String.join("", word1);
            String resWord2 = String.join("", word2);
            return resWord1.equals(resWord2);
        }
    }
}