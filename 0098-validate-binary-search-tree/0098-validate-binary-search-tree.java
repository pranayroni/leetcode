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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        Integer prev = null;
        while(node!=null || s.size()>0)
        {
            
            while(node!=null)
            {
                s.push(node);
                
                // if(node.left == null)
                // {
                //     if(prev != null && node.val<=prev) return false;
                // }
                node = node.left;
            }
            node = s.pop();
            
            if(prev != null && node.val<=prev) return false;
            prev = node.val;
            node = node.right;
        }
        return true;
       
    }
}