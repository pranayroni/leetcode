class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left =0;
        int right = 0;
        int sum =0;
        double avg = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[right];
            while((right-left)+1>k && right>=0 && left<nums.length)
            {
                sum-=nums[left];
                left++;
            }
            if((right-left)+1==k){
                avg= Math.max(avg,sum/(double)k);
            }
            right++;
        }
        return avg;
    }
}