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
    public int deepestLeavesSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty())
        {
            list.clear();
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        int sum = 0;
        for(Integer x: list) sum+=x;
        return sum;
    }
}