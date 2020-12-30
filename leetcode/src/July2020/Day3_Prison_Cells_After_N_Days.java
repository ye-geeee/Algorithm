package src.July2020;

import static java.lang.System.arraycopy;

public class Day3_Prison_Cells_After_N_Days {

    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            int[] res = new int[cells.length];

            int days = N % 14 == 0? 14 : N % 14;

            for(int day = 0; day < days; day++){
                for(int index = 1; index < cells.length - 1; index++){
                    res[index] = cells[index-1] == cells[index+1] ? 1 : 0;
                }
                System.arraycopy(res, 0, cells, 0, cells.length);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Day3_Prison_Cells_After_N_Days.Solution sol = new Day3_Prison_Cells_After_N_Days().new Solution();

        int tc[] = {0,1,0,1,1,0,0,1};
        int tc2[] = {1,0,0,1,0,0,1,0};
        int[] res = sol.prisonAfterNDays(tc, 7);
        int[] res2 = sol.prisonAfterNDays(tc2, 1000000000);

        for(int i = 0; i < 8; i++){
            System.out.print(res[i] + " " );
        }
        System.out.println();
    }
}
