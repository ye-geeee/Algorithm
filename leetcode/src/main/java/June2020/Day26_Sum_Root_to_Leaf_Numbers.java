package June2020;

public class Day26_Sum_Root_to_Leaf_Numbers {
    public static void main(String[] args) {
        TreeNode tc = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        tc.left = node2;
        tc.right = node3;
        node2.left = node4;
        node2.right = node5;

        Day26_Sum_Root_to_Leaf_Numbers.Solution sol = new Day26_Sum_Root_to_Leaf_Numbers().new Solution();
        System.out.println(sol.sumNumbers(tc));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            int res = 0;

            if (root.left == null && root.right == null) return root.val;
            if (root.left != null) {
                root.left.val += 10 * root.val;
                res += sumNumbers(root.left);
            }
            if (root.right != null) {
                root.right.val += 10 * root.val;
                res += sumNumbers(root.right);
            }
            return res;
        }
    }
}

