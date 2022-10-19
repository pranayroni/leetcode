class Solution {
    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int res =1;
        if(prefix[0]<0)
            {
                res = Math.max(res,Math.abs(prefix[0])+1);
            }
        
        for(int i=1; i<prefix.length; i++)
        {
            prefix[i] = prefix[i-1] + nums[i];
            if(prefix[i]<0)
            {
                res = Math.max(res,Math.abs(prefix[i])+1);
            }
        }
        return res;
    }
}