package MoonsAndUmbrellas;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for(int tc = 1; tc <= TC; tc++) {
            int CJ = sc.nextInt();
            int JC = sc.nextInt();
            String str = sc.next();
            StringBuilder sb = new StringBuilder(str);

            long[][] res = new long[2][str.length()];
            res[0][0] = 0;
            res[1][0] = 0;
            if (str.charAt(0) == 'C') res[1][0] = Integer.MAX_VALUE;
            else if (str.charAt(0) == 'J') res[0][0] = Integer.MAX_VALUE;

            for(int i = 1; i < str.length(); i++) {
                if (sb.charAt(i) == 'C') {
                    res[1][i] = Integer.MAX_VALUE;
                    res[0][i] = Math.min(res[0][i-1] + 0, res[1][i-1] + JC);
                }
                else if (sb.charAt(i) == 'J') {
                    res[0][i] = Integer.MAX_VALUE;
                    res[1][i] = Math.min(res[0][i-1] + CJ, res[1][i-1] + 0);
                }
                else if (sb.charAt(i) == '?') {
                    res[0][i] = Math.min(res[0][i-1] + 0, res[1][i-1] + JC);
                    res[1][i] = Math.min(res[0][i-1] + CJ, res[1][i-1] + 0);
                }
                int x = 0;
            }

            System.out.println("Case #" + tc + ": " + Math.min(res[0][str.length() - 1], res[1][str.length() - 1]));
            sc.nextLine();
        }
    }
}
