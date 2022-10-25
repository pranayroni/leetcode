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
    private int answer=0;
    public boolean isLeaf(TreeNode x)
    {
        return x.left == null && x.right == null;
    }
    public void md(TreeNode root,int depth)
    {
        if(root ==null) return;
        if(isLeaf(root))
        {
            answer = Math.max(answer,depth);
        }
        md(root.left,depth+1);
        md(root.right,depth+1);
        
    }
    public int maxDepth(TreeNode root) {
        md(root,1);
        return answer;
    }
}