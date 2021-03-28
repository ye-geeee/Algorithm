package ReversortEngineering;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for(int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int C = sc.nextInt();
            int[] res = new int[N];

            int cnt = 0;
            for(int i = 0; i < N; i++) {
                cnt += (i + 1);
            }

            if (C > (cnt - 1) || C < (res.length - 1)) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
                continue;
            }

            int start = 0;
            int end = res.length - 1;
            int num = 1;

            // reverse total
            while(C > 0 && C > (res.length * 2 - num * 2)) {
                if (num % 2 == 1) {
                    res[end--] = num;
                }
                else {
                    res[start++] = num;
                }
                C -= (res.length + 1 - num);
                num++;
                int x = 0;
            }

            int num2reverse = C - (res.length - num);

            if (num % 2 == 0) {
                for(int i = end - num2reverse; i <= end; i++) {
                    res[i] = num++;
                }
                for(int i = end - num2reverse - 1; i >= start; i--) {
                    res[i] = num++;
                }
            }
            else {
                for(int i = start + num2reverse; i >= start; i--) {
                    res[i] = num++;
                }

                for(int i = start + num2reverse + 1; i <= end; i++) {
                    res[i] = num++;
                }
            }



            System.out.print("Case #" + tc + ": ");
            for(int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
