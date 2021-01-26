package January2021;

import java.util.Arrays;

public class Day23_Sort_the_Matrix_Diagonally {
    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        System.out.println(Arrays.deepToString(new Solution().diagonalSort(mat)));
    }

    static class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int[] arr;
            for (int i = 0; i < mat[0].length; i++) {
                int arrLength = Math.min(mat[0].length - i, mat.length);
                arr = new int[arrLength];

                for (int j = 0; j < arrLength; j++) {
                    arr[j] = mat[j][i + j];
                }

                Arrays.sort(arr);
                for (int j = 0; j < arrLength; j++) {
                    mat[j][i + j] = arr[j];
                }
            }

            for (int i = 1; i < mat.length; i++) {
                int arrLength = Math.min(mat.length - i, mat[0].length);
                arr = new int[arrLength];

                for (int j = 0; j < arrLength; j++) {
                    arr[j] = mat[i + j][j];
                }

                Arrays.sort(arr);
                for (int j = 0; j < arrLength; j++) {
                    mat[i + j][j] = arr[j];
                }
            }

            return mat;
        }
    }
}
