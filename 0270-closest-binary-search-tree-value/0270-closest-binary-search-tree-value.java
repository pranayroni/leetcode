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
    public int closestValue(TreeNode root, double target) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        double min = Double.MAX_VALUE;
        int res=0;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if(Math.abs(target-node.val) < min) 
            {
                min = Math.abs(target-node.val);
                res =node.val;
            }
            node = node.right;
        }
        return res;
    }
}