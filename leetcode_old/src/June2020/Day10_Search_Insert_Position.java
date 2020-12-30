public class Day10_Search_Insert_Position {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;

            while(start != end){
                int length = end - start + 1;
                int cmpIndex = start + length/2;

                if(nums[cmpIndex] < target){
                    start = cmpIndex;
                }
                else{
                    end = cmpIndex-1;
                }
            }
            if(nums[start] >= target) return start;
            else return start + 1;
        }
    }

    public static void main(String[] args) {
        int tc[] = {1};

        Day10_Search_Insert_Position.Solution sol = new Day10_Search_Insert_Position().new Solution();
        System.out.println(sol.searchInsert(tc, 1));
    }
}

