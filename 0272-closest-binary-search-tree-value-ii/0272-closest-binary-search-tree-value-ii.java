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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        Deque<TreeNode> s = new ArrayDeque<>();
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                res.add(node.val);
                node = node.right;
            }
            node = s.pop();
            node = node.left;
        }
        Collections.sort(res, new Comparator<Integer> ()
                         {
                             @Override
                             public int compare(Integer a, Integer b)
                             {
                                 if(Math.abs(a-target) < Math.abs(b-target)) return -1;
                                 return 1;
                             }
                         });
        return res.subList(0,k);
        
    }
}