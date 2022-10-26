class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left  =0;
        int right = nums.length-1;
        while(left<=right)
        {
            int middle = (left+right)/2;
            if(nums[middle] == target)
            {
                System.out.println(middle);
                left = middle;
                while(left>=0 && nums[left] == target) {
                    left--;
                }
                right = middle;
                while(right<nums.length && nums[right] == target)
                {
                    right++;
                }
                return new int[]{left+1,right-1};
            }
            else if(target>nums[middle]) left = middle+1;
            else if(target<nums[middle]) right = middle-1;
        }
        return new int[]{-1,-1};
    }
}