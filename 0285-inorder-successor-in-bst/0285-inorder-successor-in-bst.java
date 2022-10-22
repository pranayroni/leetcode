/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> s = new ArrayDeque<>();
        if(root==null) return null;
        TreeNode node = root;
        boolean found = false;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if(found) return node;
            if(node == p) found = true;
            node = node.right;
            
        }
        return null;
    }
}