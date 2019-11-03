package main.java;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */

public class BinaryTreeMaxPathSum {
    private int max = 0;


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public int maxPathSum(TreeNode root) {
        if (root != null) max = root.val;
        findMax(root);
        return max;
    }

    private int findMax(TreeNode root) {
        if (root == null) return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);

        int result = root.val;
        int curr = result;

        if (left > 0 || right > 0) {
            curr = right > left ? result + right : result + left;
        }

        if (left > 0) result += left;
        if (right > 0) result += right;
        max = Math.max(max, result);

        return curr;
    }
}
