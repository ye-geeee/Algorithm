import java.util.ArrayList;
public class Day4_Ugly_Number2 {

    class Solution {

        int MAXARR = 2000;
        int res [] = new int[2000];


        Solution(){
            res[1] = 1;
            int mul2 = 1, mul3 = 1, mul5 = 1;
            for(int i = 2; i < MAXARR; i++){

                res[i] = min(res[mul2] * 2, res[mul3] * 3, res[mul5] * 5);

                if(res[i] == res[mul2] * 2) mul2++;
                if(res[i] == res[mul3] * 3) mul3++;
                if(res[i] == res[mul5] * 5) mul5++;
            }
        }

        public int min(int a, int b, int c){
            if(a < b && a < c) return a;
            if(b <= a && b < c) return b;
            if(c <= b && c <= a) return c;
            return 0;
        }

        public int nthUglyNumber(int n) {
            return res[n];
        }
    }

    public static void main(String[] args) {
        Day4_Ugly_Number2.Solution sol = new Day4_Ugly_Number2().new Solution();
        System.out.println(sol.nthUglyNumber(13));
    }
}
