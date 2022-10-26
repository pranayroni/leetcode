class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m =0;
        while(l<=r)
        {
            m = (l+r)/2;
            if(m>nums.length-1) return nums.length;
            if(nums[m] == target) return m;
            else if(target>nums[m]) l = m+1;
            else if(target<nums[m]) r = m-1;
        }
        if(target>nums[m]) return m+1;
        return m;
    }
}