package January2021;

public class Day17_Conut_Sorted_Vowel_Strings {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Day17_Conut_Sorted_Vowel_Strings.Solution().countVowelStrings(n));
    }

    static class Solution {

        int[][] res = new int[51][6];

        public int countVowelStrings(int n) {
            if (res[1][1] != 0) return res[n][5];
            else {
                for(int i = 1; i <= 5; i++) {
                    res[1][i] = i;
                }

                for(int i = 2; i <= 50; i++) {
                    int tempRes = 0;
                    for(int j = 1; j <= 5; j++) {
                        tempRes += res[i-1][j];
                        res[i][j] = tempRes;
                    }
                }
            }
            return res[n][5];
        }
    }
}
