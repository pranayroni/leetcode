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
        // hashmap that contains all p and q parents
        // set containing all of ps parents
        // until q is contained in that set, we traverse up qs parents
        
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        parents.put(root,null);
        s.push(root);
        while(!(parents.containsKey(p) && parents.containsKey(q)))
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
        Set<TreeNode> a = new HashSet<>();
        while(p!=null)
        {
            a.add(p);
            p = parents.get(p);
        }
        while(!a.contains(q))
        {
            q = parents.get(q);
        }
        return q;
    }
}