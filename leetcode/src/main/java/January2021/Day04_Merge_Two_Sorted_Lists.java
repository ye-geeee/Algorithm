package January2021;

public class Day04_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        ListNode l2 = new ListNode(5);

        l1.next = new ListNode(3);
        l2.next = new ListNode(7);

        System.out.println(new Day04_Merge_Two_Sorted_Lists.Solution().mergeTwoLists(l1, l2));
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode cur = res;

            while (l1 != null && l2 != null) {
                cur.next = new ListNode();
                if (l1.val < l2.val) {
                    cur.next.val = l1.val;
                    l1 = l1.next;
                } else {
                    cur.next.val = l2.val;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            while (l1 != null) {
                cur.next = new ListNode();
                cur.next.val = l1.val;
                cur = cur.next;
                l1 = l1.next;
            }

            while (l2 != null) {
                cur.next = new ListNode();
                cur.next.val = l2.val;
                cur = cur.next;
                l2 = l2.next;
            }

            return res.next;
        }
    }
}
