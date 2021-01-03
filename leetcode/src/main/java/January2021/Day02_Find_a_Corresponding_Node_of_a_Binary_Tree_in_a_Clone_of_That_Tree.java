package January2021;

public class Day02_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (cloned == null) return null;
            if (original.val == target.val) return cloned;

            TreeNode leftChildRes = getTargetCopy(original.left, cloned.left, target);
            return leftChildRes == null ?
                    getTargetCopy(original.right, cloned.right, target) : leftChildRes;
        }
    }
}
