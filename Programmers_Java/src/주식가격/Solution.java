package 주식가격;

import java.util.Arrays;
import java.util.Stack;

class Solution {

    class Price {
        int value;
        int timestamp;

        public Price(int value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Price> stack = new Stack<>();
        int timestamp;

        for (timestamp = 0; timestamp < prices.length; timestamp++){
            Price curPrice = new Price(prices[timestamp], timestamp);

            while(!stack.empty() && stack.peek().value > curPrice.value) {
                Price poppedPrice = stack.pop();
                answer[poppedPrice.timestamp] = timestamp - poppedPrice.timestamp;
            }
            stack.push(curPrice);
        }

        timestamp -= 1;
        while(!stack.empty()) {
            Price poppedPrice = stack.pop();
            answer[poppedPrice.timestamp] = timestamp - poppedPrice.timestamp;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(new Solution().solution(prices)));
    }
}