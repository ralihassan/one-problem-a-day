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
class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maxSum = root.val;
        int maxLevel = 1;
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() != 0) {
            Queue<TreeNode> tQueue = new LinkedList<>();
            level++;

            int sum = 0;

            while (queue.size() != 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) tQueue.add(node.left);
                if (node.right != null) tQueue.add(node.right);
            }

            if (sum > maxSum) {
                maxLevel = level;
                maxSum = sum;
            } 
            queue = tQueue;
        }

        return maxLevel;
    }
}