class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            int left = i+1;
            int right = nums.length-1;
            while(left<=right)
            {
                int middle = (left+right)/2;
                if(nums[middle] == nums[i]) return nums[i];
                if(nums[i]>nums[middle]) left = middle+1;
                else right = middle-1;
            }
            
        }
        return -1;
    }
}