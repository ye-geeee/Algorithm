package 기능개발;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        int preMaxDays = getDays(progresses[0], speeds[0]);
        int num = 1;

        for (int i = 1; i < progresses.length; i++) {
            int days = getDays(progresses[i], speeds[i]);

            if (days > preMaxDays) {
                answer.add(num);
                num = 1;
                preMaxDays = days;
            }
            else {
                num++;
            }
        }
        answer.add(num);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int getDays(int progresss, int speed) {
        return (100 - progresss) % speed == 0?
                (100 - progresss) / speed : (100 - progresss) / speed + 1;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(new Solution().solution(progresses, speeds)));
    }
}
