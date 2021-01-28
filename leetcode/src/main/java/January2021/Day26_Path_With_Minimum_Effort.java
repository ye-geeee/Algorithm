package January2021;

public class Day26_Path_With_Minimum_Effort {
    public static void main(String[] args) {
        int[][] heights = {{10, 8}, {10, 8}, {1, 2}, {10, 3}, {1, 3}, {6, 3}, {5, 2}};
        System.out.println(new Day26_Path_With_Minimum_Effort.Solution().minimumEffortPath(heights));
    }

    static class Solution {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int rowLen;
        int colLen;

        public int minimumEffortPath(int[][] heights) {
            rowLen = heights.length;
            colLen = heights[0].length;

            int minimum = Integer.MAX_VALUE;
            int maximum = 0;

            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    minimum = Math.min(minimum, heights[i][j]);
                    maximum = Math.max(maximum, heights[i][j]);
                }
            }

            return searchMinimumK(0, maximum - minimum, heights);
        }

        public int searchMinimumK(int min, int max, int[][] heights) {
            if (min == max) return min;

            int mid = (min + max) / 2;
            boolean[][] visited = new boolean[rowLen][colLen];
            visited[0][0] = true;

            if (available(mid, 0, 0, heights, visited)) {
                return searchMinimumK(min, mid, heights);
            } else {
                // System.out.println(mid + " " + max);
                return searchMinimumK(mid + 1, max, heights);
            }
        }

        public boolean available(int k, int row, int col, int[][] heights, boolean[][] visited) {
            if (row == heights.length - 1 && col == heights[0].length - 1) {
                return true;
            }

            boolean res = false;
            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {
                int newX = row + dx[i];
                int newY = col + dy[i];

                if (newX >= 0 && newY >= 0 && newX < rowLen && newY < colLen && !visited[newX][newY]
                        && Math.abs(heights[newX][newY] - heights[row][col]) <= k) {
                    res = available(k, newX, newY, heights, visited);
                    if (res) break;
                }
            }

            return res;
        }
    }
}
