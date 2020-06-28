public class Day11_Sort_Colors {
    class Solution {
        public void sortColors(int[] nums) {
            int res[] = new int[3];
            for(int i = 0; i < nums.length; i++){
                res[nums[i]]++;
            }

            int index = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < res[i]; j++){
                    nums[index++] = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        int tc[] = {2, 0, 2, 1, 1, 0};

        Day11_Sort_Colors.Solution sol = new Day11_Sort_Colors().new Solution();
        sol.sortColors(tc);
        System.out.println(tc);
    }
}

