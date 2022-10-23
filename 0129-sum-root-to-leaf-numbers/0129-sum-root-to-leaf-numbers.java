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
        if(x == null) return false;
        return x.left == null && x.right == null;
    }
    public int sumNumbers(TreeNode root) {
        Deque<Pair<TreeNode,Integer>> s = new ArrayDeque<>();
        int res = 0;
        int curr =0;
        TreeNode node;
        s.push(new Pair(root,0));
        while(!s.isEmpty())
        {
            Pair<TreeNode,Integer> p = s.pop();
            node = p.getKey();
            curr = p.getValue();
            
            if(node!=null)
            {
                curr = curr*10+node.val;
                if(isLeaf(node)) res+=curr;
                s.push(new Pair(node.right,curr));
                s.push(new Pair(node.left,curr));
            } 
        
        
        
    }
        return res;
}
}