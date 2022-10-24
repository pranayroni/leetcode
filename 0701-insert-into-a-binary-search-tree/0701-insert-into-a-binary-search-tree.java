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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        if(node == null) return new TreeNode(val);
        while(node!=null)
        {
            if(val>node.val && node.right==null)
            {
                System.out.println(node.val);
                node.right = new TreeNode(val);
                break;
            } else if(val>node.val) node = node.right;
            if(val<node.val && node.left == null)
            {
                System.out.println(node.val);
                node.left = new TreeNode(val);
                break;
            } else if(val<node.val) node = node.left;
        }
        return root;
    }
}