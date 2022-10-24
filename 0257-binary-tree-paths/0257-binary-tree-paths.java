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
        return x.left == null && x.right == null;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        Pair<TreeNode,String> p = new Pair(root,"");
        Deque<Pair<TreeNode,String>> s = new ArrayDeque<>();
        TreeNode node = p.getKey();
        List<String> res = new ArrayList<>();
        while(node!=null || s.size()>0)
        {
            while(node !=null)
            {
                if(isLeaf(node))
                {
                    String prev = p.getValue();
                    p = new Pair(node,prev+node.val);
                    res.add(p.getValue());
                } else {
                    String prev = p.getValue();
                    p = new Pair(node,prev+node.val+"->");
                }
                s.push(p);
                node = node.left;
            }
            p = s.pop();
            node = p.getKey();
            node = node.right;
        }
        return res;
    }
}