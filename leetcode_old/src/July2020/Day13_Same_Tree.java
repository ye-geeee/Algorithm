public class Day13_Same_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public boolean isSameTree(TreeNode p, TreeNode q) {

            if(p == null && q == null) return true;
            if(p == null) return false;
            if(q == null) return false;

            if(p.val != q.val) return false;
            else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }
    }

    public static void main(String[] args) {
        Day13_Same_Tree.Solution sol = new Day13_Same_Tree().new Solution();
    }
}
