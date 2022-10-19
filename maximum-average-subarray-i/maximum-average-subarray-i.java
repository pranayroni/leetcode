class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left =0;
        int right =0;
        int sum =0;
        Double avg = null;
        while(left<nums.length && right<nums.length)
        {
            sum+=nums[right];
            if((right-left)+1 >k)
            {
                sum-=nums[left];
                left++;
            }
            if((right-left)+1 == k)
            {
                if(avg==null) avg = sum/(double)k;
                else avg = Math.max(avg,sum/(double)k);
            }
            right++;
        }
        return avg;
    }
}