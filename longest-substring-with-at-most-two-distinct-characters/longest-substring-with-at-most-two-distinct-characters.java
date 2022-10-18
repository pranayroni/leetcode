class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left =0;
        int right = 0;
        Map<Character,Integer> hm = new HashMap<>();
        int longest =0;
        
        while(right<s.length())
        {
            hm.put(s.charAt(right),right++);
            
            if(hm.size()>2)
            {
                // grab left most character and jump to most recent index+1
                int index = Collections.min(hm.values());
                hm.remove(s.charAt(index));
                left=index+1;
            }
            longest = Math.max(longest,right-left);
        }
        
        return longest;
    }
}