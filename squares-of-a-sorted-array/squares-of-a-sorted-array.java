class Solution {
    public int min(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i<arr.length; i++)
        {
            
            if(Math.abs(arr[i]) <min) {min = Math.abs(arr[i]); res = i;}
        }
        return res;
    }
    public int[] sortedSquares(int[] nums) {
        int left = min(nums)-1;
        int right = min(nums)+1;
        int[] res = new int[nums.length];
        int counter =0;
        res[counter++] = (int)Math.pow(nums[min(nums)],2);
        while(left>=0 || right<nums.length)
        {
            if(left>=0 && right<nums.length)
            {
                if(Math.pow(nums[left],2) < Math.pow(nums[right],2))
                {
                    res[counter++] = (int)Math.pow(nums[left],2); left--;
                } else if(Math.pow(nums[left],2) > Math.pow(nums[right],2))
                {
                    res[counter++] = (int)Math.pow(nums[right],2); right++;
                } else
                {
                    res[counter++] = (int)Math.pow(nums[left],2); 
                    res[counter++] = (int)Math.pow(nums[right],2);
                    left--;
                    right++;
                }
            } else if(left>=0) 
            {
                res[counter++] = (int)Math.pow(nums[left],2); left--;
            } else 
            {
                res[counter++] = (int)Math.pow(nums[right],2); right++;
            }
            
        }
        return res;
    }
}