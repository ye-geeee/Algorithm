package src.July2020;

public class Day6_Plus_One {

    public static void main(String[] args) {
        Day6_Plus_One.Solution sol = new Day6_Plus_One().new Solution();
        int[] tc = {9};
        int[] res = sol.plusOne(tc);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    class Solution {
        public int[] plusOne(int[] digits) {

            boolean need2moveArr = true;
            int[] newDigits = new int[digits.length + 1];

            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                newDigits[i + 1] = digits[i];
                if (digits[i] == 10) {
                    digits[i] = 0;
                    newDigits[i + 1] = 0;
                } else {
                    need2moveArr = false;
                    break;
                }
            }
            if (!need2moveArr) return digits;
            else {
                newDigits[0] = 1;
                return newDigits;
            }
        }
    }
}
