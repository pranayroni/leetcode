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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Integer max = null;
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode node = q.poll();
                if(max == null) max = node.val;
                else max = Math.max(max,node.val);
                
                if(node.left !=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
    
}