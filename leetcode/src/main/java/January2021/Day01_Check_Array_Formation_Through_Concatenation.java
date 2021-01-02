package January2021;

import java.util.HashMap;

public class Day01_Check_Array_Formation_Through_Concatenation {
    public static void main(String[] args) {
        int[] arr = {85};
        int[][] pieces = {{85}};

        System.out.println(new Solution().canFormArray(arr, pieces));

        arr = new int[]{49, 18, 16};
        pieces = new int[][]{{16, 18, 49}};

        System.out.println(new Solution().canFormArray(arr, pieces));

        arr = new int[]{91, 4, 64, 78};
        pieces = new int[][]{{78}, {4, 64}, {91}};

        System.out.println(new Solution().canFormArray(arr, pieces));
    }

    static class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            HashMap<Integer, int[]> hashPieces = new HashMap<>();

            for (int[] piece : pieces) {
                hashPieces.put(piece[0], piece);
            }

            boolean res = true;
            int index = 0;

            while (res && index < arr.length) {
                if (!hashPieces.containsKey(arr[index])) {
                    res = false;
                    break;
                }

                int[] piece = hashPieces.get(arr[index]);
                if (arr.length - index >= piece.length) {
                    for (int element : piece) {
                        if (arr[index++] != element) {
                            res = false;
                            break;
                        }
                    }
                } else {
                    res = false;
                }
            }

            return res;
        }
    }
}
