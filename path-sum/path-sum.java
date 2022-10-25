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
        return x.left==null && x.right == null;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<Pair<TreeNode,Integer>> s = new ArrayDeque<>();
        int res =0;
        int curr =0;
        s.push(new Pair(root,curr));
        while(!s.isEmpty())
        {
            Pair<TreeNode,Integer> p = s.pop();
            TreeNode node = p.getKey();
            curr = p.getValue();
            
            if(node!=null)
            {
                curr = curr+node.val;
                if(curr == targetSum && isLeaf(node)) return true;
                s.push(new Pair(node.right,curr));
                s.push(new Pair(node.left,curr));
            }
        }
        return false;
    }
}