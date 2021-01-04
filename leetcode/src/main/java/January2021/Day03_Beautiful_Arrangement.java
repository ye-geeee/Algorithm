package January2021;

public class Day03_Beautiful_Arrangement {
    public static void main(String[] args) {
        System.out.println(new Day03_Beautiful_Arrangement.Solution().countArrangement(2));
    }

    static class Solution {
        public int countArrangement(int n) {
            boolean[] visited = new boolean[n + 1];
            return countArrangementRecursive(n, 1, visited);
        }

        public int countArrangementRecursive(int n, int index, boolean[] visited) {
            if (index < 1) return 1;
            int res = 0;

            for (int i = n; i >= 1; i--) {
                if (!visited[i] && (index % i == 0 || i % index == 0)) {
                    visited[i] = true;
                    res += countArrangementRecursive(n, index - 1, visited);
                    visited[i] = false;
                }
            }
            return res;
        }
    }
}
