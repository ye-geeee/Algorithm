package January2021;

public class Day05_Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        System.out.println(new Day05_Remove_Duplicates_from_Sorted_List.Solution().deleteDuplicates(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(4,
                                                                new ListNode(5)))))))));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode res = new ListNode();
            ListNode cur = res;
            int dupNum = Integer.MAX_VALUE;

            while (head != null) {
                if (head.val == dupNum || (head.next != null && head.val == head.next.val)) {
                    dupNum = head.val;
                } else {
                    cur.next = new ListNode(head.val);
                    cur = cur.next;
                }

                head = head.next;
            }

            return res.next;
        }
    }
}
