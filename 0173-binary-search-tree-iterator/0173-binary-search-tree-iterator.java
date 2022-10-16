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
class BSTIterator {

    Queue<TreeNode> list = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(node);
                node = node.left;
            }
            
            node = s.pop();
            list.add(node);
            node = node.right;
        }
    }
    
    public int next() {
        TreeNode node = list.poll();
        return node.val;
        
    }
    
    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */