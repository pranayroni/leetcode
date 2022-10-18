class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0;
        int right = 0;
        int ones = 0;
        int zeros = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[right] == 0)
            {
                zeros++;
                while(zeros>k && left<nums.length)
                {
                    if(nums[left] == 0) {
                        zeros--;
                        left++;
                    } else left++;
                }
                ones = Math.max(ones,(right-left)+1);
                right++;
            } else {ones = Math.max(ones,(right-left)+1); right++;}
            // System.out.println("Window: >> Left: "+left+" Right: "+right);
            
        }
        return ones;
        
    }
}