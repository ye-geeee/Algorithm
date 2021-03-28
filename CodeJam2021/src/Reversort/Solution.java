package Reversort;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for(int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int[] sorted = new int[N];
            int[] loc = new int[N + 1];
            int res = 0;

            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                sorted[i] = arr[i];
                loc[arr[i]] = i;
                int x = 0;
            }

            Arrays.sort(sorted);

            for(int i = 0; i < N - 1; i++) {
                int j = loc[sorted[i]];

                for(int idx = 0; idx < (j + 1 - i) / 2; idx++) {
                    int temp = arr[i + idx];
                    arr[i + idx] = arr[j - idx];
                    loc[arr[j - idx]] = i + idx;
                    arr[j - idx] = temp;
                    loc[temp] = j - idx;

                    int x = 0;
                }

                res += (j - i + 1);
            }

            System.out.println("Case #" + tc + ": " + res);
        }
    }
}
