package January2021;

public class Day15_Get_Maximum_in_Generated_Array {
    public static void main(String[] args) {
        System.out.println(new Day15_Get_Maximum_in_Generated_Array.Solution().getMaximumGenerated(7));
    }

    static class Solution {
        int[] arr = new int[101];
        int[] max = new int[101];

        public int getMaximumGenerated(int n) {
            if (arr[n] != 0) return arr[n];
            else {
                arr[0] = 0;
                arr[1] = 1;

                max[0] = 0;
                max[1] = 1;

                for (int i = 2; i <= 100; i++) {
                    if (i % 2 == 0) arr[i] = arr[i / 2];
                    else {
                        arr[i] = arr[i / 2] + arr[i / 2 + 1];
                    }
                    max[i] = Math.max(max[i - 1], arr[i]);
                }
                return max[n];
            }
        }
    }
}
