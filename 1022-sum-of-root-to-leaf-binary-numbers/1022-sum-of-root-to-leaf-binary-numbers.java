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
    public boolean isLeaf(TreeNode node)
    {
        return node.left == null && node.right == null;
    }
    public int sumRootToLeaf(TreeNode root) {
        // c = (c << 1) | node.val
    
        int res =0;
        Pair<TreeNode,Integer> p = new Pair(root,0);
        Deque<Pair<TreeNode,Integer>> s = new ArrayDeque<>();
        TreeNode node = root;
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                int curr = p.getValue();
                curr = (curr << 1) | node.val;
                p = new Pair(node,curr);
                s.push(p);
                if(isLeaf(node))
                {
                    res+=curr;
                    break;
                } else
                node = node.left;
            }
            p = s.pop();
            node = p.getKey();
            node = node.right;
        }
        return res;
    }
}