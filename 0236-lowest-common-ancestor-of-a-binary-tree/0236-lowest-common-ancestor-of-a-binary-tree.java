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
        // make hashmap of all nodes and their parents
        // put all of ps ancestors in a set
        // while q is not in that set, we go up qs ancestors until we find a common match
        // when match is found we return that q
        
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        Deque<TreeNode> s= new ArrayDeque<>();
        parents.put(root,null);
        s.push(root);
        while(!parents.containsKey(p) || !parents.containsKey(q))
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
        
        Set<TreeNode> set = new HashSet<>();
        while(p!=null)
        {
            set.add(p);
            p = parents.get(p);
        }
        while(!set.contains(q))
        {
            q = parents.get(q);
        }
        return q;
        
        
        }
}