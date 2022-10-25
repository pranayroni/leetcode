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
    public boolean check(TreeNode root)
    {
        Deque<TreeNode> s = new ArrayDeque<>();
        int c = root.val;
        TreeNode node = root;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                if(node.val!=c) return false;
                node = node.left;
            }
            node = s.pop();
            node = node.right;
        }
        return true;
    }
    public int countUnivalSubtrees(TreeNode root) {
        Deque<TreeNode> s= new ArrayDeque<>();
        int count = 0;
        TreeNode node = root;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                if(check(node)) count++;
                node = node.left;
            }
            node = s.pop();
            node = node.right;
        }
        
        
        
        return count;
    }
}