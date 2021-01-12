package January2021;

public class Day12_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(new Day12_Add_Two_Numbers.Solution().addTwoNumbers(l1, l2));
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode cur = res;

            int carrier = 0;

            while (l1 != null && l2 != null) {
                cur.next = new ListNode((l1.val + l2.val + carrier) % 10);
                carrier = (l1.val + l2.val + carrier) / 10;

                l1 = l1.next;
                l2 = l2.next;
                cur = cur.next;
            }

            while (l1 != null) {
                cur.next = new ListNode((l1.val + carrier) % 10);
                carrier = (l1.val + carrier) / 10;

                l1 = l1.next;
                cur = cur.next;
            }

            while (l2 != null) {
                cur.next = new ListNode((l2.val + carrier) % 10);
                carrier = (l2.val + carrier) / 10;

                l2 = l2.next;
                cur = cur.next;
            }

            if (carrier != 0) {
                cur.next = new ListNode(carrier);
            }

            return res.next;
        }
    }
}
