package July2020;

public class Day14_Angles_Between_Hands_Of_A_Clock {

    public static void main(String[] args) {
        Day14_Angles_Between_Hands_Of_A_Clock.Solution sol = new Day14_Angles_Between_Hands_Of_A_Clock().new Solution();

    }

    class Solution {
        public double angleClock(int hour, int minutes) {
            return Math.min(Math.abs((minutes * 6) - ((hour % 12) * 30 + 0.5 * minutes)), 360 - Math.abs((minutes * 6) - ((hour % 12) * 30 + 0.5 * minutes)));
        }
    }
}
