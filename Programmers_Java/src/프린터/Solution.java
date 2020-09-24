package 프린터;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    class Document {
        int priority;
        int idx;

        public Document(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }

    public int solution(int[] priorities, int location) {
        int[] answer = new int[priorities.length];
        int[] importance = new int[10];
        Deque<Document> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(priorities[i], i));
            importance[priorities[i]]++;
        }

        int importanceIdx = 9;
        int poppedIdx = 1;
        while(!queue.isEmpty()) {
            if (importance[importanceIdx] == 0){
                importanceIdx--;
                continue;
            }

            while (importance[importanceIdx] != 0) {
                while(queue.peek().priority != importanceIdx) {
                    queue.add(queue.pop());
                }
                answer[queue.pop().idx] = poppedIdx++;
                importance[importanceIdx]--;
            }
        }

        return answer[location];
    }

    public static void main(String[] args) {
        int[] priorities = {9, 9, 9, 9};
        System.out.println(new Solution().solution(priorities, 2));
    }
}
