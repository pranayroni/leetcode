class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left =0;
        int right =0;
        if(s.length() == 2) return s.length();
        Map<Character, Integer> hm = new HashMap<>();
        int res =0;
        while(left<s.length() && right<s.length())
        {
            hm.put(s.charAt(right),right++);
            if(hm.size()>2)
            {
                int index = Collections.min(hm.values());
                hm.remove(s.charAt(index));
                left = index+1;
            }
            res = Math.max(res,(right-left));
            
        }
        
        return res;
    }
}