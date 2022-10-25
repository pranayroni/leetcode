class Solution {
    public int[] runningSum(int[] nums) {
        if(nums.length == 1) return nums;
        
        // {1} -> {1}
        for(int i=1; i<nums.length; i++)
        {
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
        
    }
}