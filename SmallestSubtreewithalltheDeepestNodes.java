class SmallestSubtreewithalltheDeepestNodes {

    Map<TreeNode, Integer> depth;
    int max_depth = -1;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap();
        dfs(root, 0);
        return answer(root);
    }

    public void dfs(TreeNode node, int depth) {
        if (node != null) {
            max_depth = Math.max(max_depth, depth);
            depth.put(node, depth);
            dfs(node.left, depth+1);
            dfs(node.right, depth+1);
        }
    }

    public TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == max_depth)
            return node;
        TreeNode L = answer(node.left),
                 R = answer(node.right);
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
    }
}