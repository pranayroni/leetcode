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
    public int countNodes(TreeNode root) {
        int res = 0;
        Stack<TreeNode> s = new Stack<>();
        if(root == null) return res;
        TreeNode node = root;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                res++;
                node = node.left;
            }
            node = s.pop();
            node = node.right;
        }
        return res;
    }
}