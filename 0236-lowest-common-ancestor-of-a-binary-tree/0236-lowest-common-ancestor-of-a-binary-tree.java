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
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        Set<TreeNode> ancestors = new HashSet<>();
        parents.put(root,null);
        s.push(root);
        while(!(parents.keySet().contains(p) && parents.keySet().contains(q)))
        {
            TreeNode node = s.pop();
            if(node.left!=null)
            {
                parents.put(node.left,node);
                s.push(node.left);
            }
            if(node.right!=null)
            {
                parents.put(node.right,node);
                s.push(node.right);
            }
        }
        while(p!=null)
        {
            ancestors.add(p);
            p = parents.get(p);
        }
        while(!ancestors.contains(q))
        {
            q = parents.get(q);
        }
        return q;
    }
}