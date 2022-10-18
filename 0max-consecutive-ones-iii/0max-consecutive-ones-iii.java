class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0;
        int right =0;
        int ones = 0;
        int zeros =0;
        while(left<nums.length && right<nums.length)
        {
            if(nums[right] == 0)
            {
                zeros++;
                while(zeros>k)
                {
                    if(nums[left] == 0)
                    {
                        zeros--;
                        left++;
                    }
                    else left++;
                }
                ones = Math.max(ones,(right-left)+1);
                right++;
            } else{
                ones = Math.max(ones,(right-left)+1);
                right++;
            }
        }
        
        return ones;
        
    }
}