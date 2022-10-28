/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Map<Node,Node> parents = new HashMap<>();
        Deque<Node> s = new ArrayDeque<>();
        parents.put(p,p.parent);
        parents.put(q,q.parent);
        s.push(p);
        s.push(q);
        while(!s.isEmpty())
        {
            Node node = s.pop();
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
        Node node = q;
        while(node.parent !=null)
        {
            parents.put(node,node.parent);
            node = node.parent;
        }
        Set<Node> a = new HashSet<>();
        while(p!=null)
        {
            a.add(p);
            System.out.println(p.val);
            p = parents.getOrDefault(p,p.parent);
        }
        while(!a.contains(q))
        {
            q = parents.get(q);
        }
        return q;
    }
}