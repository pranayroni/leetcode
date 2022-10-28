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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> hm = new HashMap<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        hm.put(root,null);
        s.push(root);
        
        while(!(hm.containsKey(p) && hm.containsKey(q)))
        {
            TreeNode node = s.pop();
            if(node.left!=null)
            {
                hm.put(node.left,node);
                s.add(node.left);
            }
            if(node.right!=null)
            {
                hm.put(node.right,node);
                s.add(node.right);
            }
        }
        Set<TreeNode> a = new HashSet<>();
        while(p!=null)
        {
            a.add(p);
            p = hm.get(p);
        }
        while(!a.contains(q))
        {
            q = hm.get(q);
        }
        return q;
    }
}