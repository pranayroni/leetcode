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
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root!=null) q.add(root);
        int level =0;
        while(!q.isEmpty())
        {
            int size =q.size();
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                TreeNode node = q.removeFirst();
                
                if(level%2==1)
                {    // for each odd level, store the node refs and the values in an array
                    nodes.add(node);
                    vals.add(node.val);
                } 
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);    
                
                
            }
            
            // after finishing collecting nodes and vals on odd levels, keep node refs same, just update vals in backswards
            for(int i=0; i<nodes.size(); i++)
            {
                nodes.get(i).val = vals.get(vals.size()-1-i);
            }
            nodes.clear();
            vals.clear();
            level++;
        }
        return root;
    }
}