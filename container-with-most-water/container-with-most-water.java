class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        for(int i=0; i<height.length; i++)
        {
            res = Math.max(res,(Math.min(height[left],height[right])*(right-left)));
            if(height[left]<height[right]) left++;
            else if (height[left]>height[right]) right--;
            else {left++; right--;}
        }
        return res;
    }
}