package src.June2020;

import java.util.Arrays;
import java.util.Comparator;

public class Day3_TwoCityScheduling {

    public static void main(String[] args) {
        int[][] tc = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        Solution sol = new Day3_TwoCityScheduling().new Solution();
        System.out.println(sol.twoCitySchedCost(tc));
    }

    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(final int[] arr1, final int[] arr2) {
                    return Integer.compare(Math.abs(arr2[0] - arr2[1]), Math.abs(arr1[0] - arr1[1]));
                }
            });

            int aGroup = 0, bGroup = 0, res = 0;

            for (int[] arr : costs) {
                if (((arr[0] <= arr[1]) && aGroup < costs.length / 2) || bGroup == costs.length / 2) {
                    aGroup++;
                    res += arr[0];
                } else {
                    bGroup++;
                    res += arr[1];
                }
            }
            return res;
        }
    }
}