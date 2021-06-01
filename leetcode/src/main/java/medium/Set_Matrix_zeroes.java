package medium;

import java.util.ArrayList;

public class Set_Matrix_zeroes {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new Set_Matrix_zeroes.Solution().setZeroes(matrix);

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + ints[j]);
            }
            System.out.println();
        }
    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            ArrayList<Pair> zeroes = new ArrayList<>();
            int row = matrix.length;
            int col = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        zeroes.add(new Pair(i, j));
                    }
                }
            }

            for (Pair zero : zeroes) {
                for (int i = 0; i < row; i++) {
                    matrix[i][zero.c] = 0;
                }

                for (int i = 0; i < col; i++) {
                    matrix[zero.r][i] = 0;
                }
            }
        }
    }

    static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
