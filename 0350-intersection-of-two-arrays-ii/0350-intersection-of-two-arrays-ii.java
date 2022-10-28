class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> s1 = new HashMap<>();
        for(int x: nums1) s1.put(x,s1.getOrDefault(x,0)+1);
        Map<Integer,Integer> s2 = new HashMap<>();
        for(int x: nums2) s2.put(x,s2.getOrDefault(x,0)+1);
        
        Set<Integer> in = new HashSet<>(s1.keySet());
        in.retainAll(s2.keySet());
        int size =0;
        for(Integer x: in) size+= Math.min(s1.get(x),s2.get(x));
        int[] res = new int[size];
        int c=0;
        for(Integer x: in)
        {
            int occ = Math.min(s1.get(x),s2.get(x));
            for(int i=0; i<occ; i++)
            {
                res[c++] = x;
            }
        }
        return res;
        
    }
}