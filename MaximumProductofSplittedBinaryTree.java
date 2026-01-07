/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MaximumProductofSplittedBinaryTree {
    long max = 0;
    long totalSum = 0;
    public int maxProduct(TreeNode root) {
        totalSum = totalSum(root);
        dfs(root);

        return (int)(max % 1000000007);
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;
        long cur = node.val + dfs(node.left) + dfs(node.right);
        max = Math.max(max, ((totalSum-cur) * cur));

        return cur;
    }

    private long totalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + totalSum(node.left) + totalSum(node.right);
    } 
}