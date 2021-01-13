package January2021;

import java.util.Arrays;

public class Day14_Boats_To_Save_People {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;

        System.out.println(new Day14_Boats_To_Save_People.Solution().numRescueBoats(people, limit));
    }

    static class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            boolean[] notVisited = new boolean[people.length];

            int i = 0;
            int j = people.length - 1;
            int ans = 0;

            while(i <= j) {
                ans++;
                if (people[j] + people[i] <= limit) i++;
                j--;
            }

            return ans;
        }
    }
}
