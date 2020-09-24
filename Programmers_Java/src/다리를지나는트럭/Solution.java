package 다리를지나는트럭;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int timestamp = 0;

        int[] truckTimeStamp = new int[truck_weights.length];
        int outIdx = 0;
        int inIdx = 0;
        int numInBridge = 0;
        int weightInBridge = 0;

        while(outIdx < truck_weights.length) {
            timestamp++;
            if (numInBridge != 0 && timestamp - truckTimeStamp[outIdx] == bridge_length) {
                weightInBridge -= truck_weights[outIdx];
                numInBridge--;
                outIdx++;
            }

            if (inIdx < truck_weights.length && weightInBridge + truck_weights[inIdx] <= weight) {
                weightInBridge += truck_weights[inIdx];
                truckTimeStamp[inIdx] = timestamp;
                numInBridge++;
                inIdx++;
            }
            int x = 0;
        }

        return timestamp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}
