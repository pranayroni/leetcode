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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int maxLevel = 0;
        Integer maxSum = null;
        int level =1;
        while(!q.isEmpty())
        {
            int size = q.size();
            int sum =0;
            for(int i=0; i<size; i++)
            {
                TreeNode node = q.removeFirst();
                sum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
            }
            if(maxSum == null)
            {
                maxLevel = level;
                maxSum = sum;
            } else{
                if(sum>maxSum)
                {
                    maxLevel = level;
                    maxSum = sum;
                }
            }
            level++;
        }
        return maxLevel;
    }
}