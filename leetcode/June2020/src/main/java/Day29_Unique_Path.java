public class Day29_Unique_Path {
    class Solution {
        public int uniquePaths(int m, int n) {
            int total = (m - 1) + (n - 1);
            int comb = m < n ? (m - 1) : (n  - 1);

            long parent = 1;
            long child = 1;

            for(int i = 1; i <= comb; i++){
                parent *= i;
                child *= (total - i + 1);

                if(child % parent == 0){
                    child /= parent;
                    parent = 1;
                }
            }

            return ((int)child/(int)parent);
        }
    }

    public static void main(String[] args) {
        Day29_Unique_Path.Solution sol = new Day29_Unique_Path().new Solution();
        System.out.println(sol.uniquePaths(10, 10));
    }
}

