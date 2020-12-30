public class Day2_DeleteNodeInLinkedList {

    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode tc = new ListNode(4);
        tc.next = new ListNode(5);
        tc.next.next = new ListNode(1);
        tc.next.next.next = new ListNode(9);

        Solution sol = new Day2_DeleteNodeInLinkedList().new Solution();
        sol.deleteNode(tc);
    }
}