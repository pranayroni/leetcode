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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int x =0;
        int y =0;
        
        Deque<Pair<TreeNode,Pair<Integer,Integer>>> s = new ArrayDeque<>();
        TreeNode node = root;
        Pair<TreeNode,Pair<Integer,Integer>> p = new Pair(node,new Pair(x,y));
        List<Pair<TreeNode,Pair<Integer,Integer>>> test = new ArrayList<>();
        while(node!=null || s.size()>0)
        {
            while(node!=null)
            {
                s.push(new Pair(node,new Pair(x,y)));
                test.add(new Pair(node,new Pair(x,y)));
                node = node.left;
                x--;
                y++;

            }
            Pair<TreeNode,Pair<Integer,Integer>> pr = s.pop();
            node = pr.getKey();
            x = pr.getValue().getKey();
            y = pr.getValue().getValue();
            node = node.right;
            x++;
            y++;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(Pair<TreeNode,Pair<Integer,Integer>> e: test)
        {
            max = Math.max(max,e.getValue().getKey());
            min = Math.min(min,e.getValue().getKey());
        }
        
        for(int i=0; i<(max-min)+1; i++)
        {
            res.add(new ArrayList<>());
        }
        min = Math.abs(min);
        
        // for(Pair<TreeNode,Pair<Integer,Integer>> l : test) 
            Collections.sort(test, new Comparator<Pair<TreeNode,Pair<Integer,Integer>>>() {
            @Override
            public int compare(Pair<TreeNode,Pair<Integer,Integer>> p1, Pair<TreeNode,Pair<Integer,Integer>> p2)
            {
                if(p1.getValue().getKey().equals(p2.getValue().getKey()))
                {
                    if(p1.getValue().getValue().equals(p2.getValue().getValue()))
                    {
                        return p1.getKey().val - p2.getKey().val;
                    } else return p1.getValue().getValue()-p2.getValue().getValue();
                } else return p1.getValue().getKey()-p2.getValue().getKey();
            }
        });
        
        for(Pair<TreeNode,Pair<Integer,Integer>> e: test)
        {
            res.get(e.getValue().getKey()+min).add(e.getKey().val);
        }
        
        

        return res;
    }
}