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
class Solution {
    public boolean isLeaf(TreeNode x)
    {
        return x.left == null && x.right == null;
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(isLeaf(root)) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levels = 1;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            levels++;
        }
        return levels-1;
    }
}