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
    public int findSecondMinimumValue(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        List<Integer> res = new ArrayList<>();
        while(node !=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if(!res.contains(node.val)) res.add(node.val);
            node = node.right;
        }
        Collections.sort(res);
        if(res.size()>=2) return res.get(1);
        return -1;
    }
}