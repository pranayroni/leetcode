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
    public boolean search(TreeNode x, int target)
    {
        if(x == null) return false;
        if(x.val == target) return true;
        else if(target>x.val) return search(x.right,target);
        else if(target<x.val) return search(x.left,target);
        return false;
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root1;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                if(search(root2,target-node.val)) return true;
                node = node.left;
            }
            node = s.pop();
            node = node.right;
        }
        return false;
    }
}