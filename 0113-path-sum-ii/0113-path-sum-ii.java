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


class Triplet{
    public final TreeNode node;
    public final Integer sum;
    public final List<Integer> list;
    
    public Triplet(TreeNode node, Integer sum, List<Integer> list)
    {
        this.node = node;
        this.sum = sum;
        this.list = list;
    }
}
class Solution {
    public boolean isLeaf(TreeNode node)
    {
        return node.left == null && node.right == null;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        TreeNode node = root;
        List<List<Integer>> res = new ArrayList<>();
        Triplet tp = new Triplet(root,0,new ArrayList<>());
        Deque<Triplet> s = new ArrayDeque<>();
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                List<Integer> l = new ArrayList<>(tp.list);
                int x = tp.sum;
                l.add(node.val);
                tp = new Triplet(node,x+node.val,l);
                s.push(tp);
                if(tp.sum==targetSum && isLeaf(node)) res.add(tp.list);
                node = tp.node.left;
            }
            tp = s.pop();
            node = tp.node.right;
            
        }
        
        return res;
    }
}