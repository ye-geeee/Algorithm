package January2021;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day24_Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(1, new ListNode(6));
        System.out.println(new Day24_Merge_K_Sorted_Lists.Solution().mergeKLists(lists));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = new ListNode();
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            for(ListNode node : lists) {
                if (node != null)
                    queue.offer(node);
            }

            ListNode cur = res;

            while(!queue.isEmpty()) {
                ListNode temp = queue.poll();
                cur.next = new ListNode(temp.val);
                cur = cur.next;
                if (temp.next != null) queue.offer(temp.next);
            }

            return res.next;
        }
    }
}
