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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();
        if(original!=null) {
            q.add(original);
            q2.add(cloned);
        }
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode og = q.poll();
                TreeNode clone = q2.poll();
                
                if(og == target) return clone;
                if(og.left!=null){
                    q.add(og.left);
                    q2.add(clone.left);
                }
                if(og.right!=null)
                {
                    q.add(og.right);
                    q2.add(clone.right);
                }
            }
        }
        return null;
    }
}