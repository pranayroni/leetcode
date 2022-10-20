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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> s = new ArrayDeque<TreeNode>();
        if(k == 1 && root.left == null && root.right == null) return root.val;
        TreeNode node = root;
        int i =0;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            i++;
            if(i == k) return node.val;
            node = node.right;
        }
        return -1;
    }
}