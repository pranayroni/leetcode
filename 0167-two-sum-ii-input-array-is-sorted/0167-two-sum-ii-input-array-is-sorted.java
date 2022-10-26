class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++)
        {
            int left = i+1;
            int right = numbers.length-1;
            int t = target-numbers[i];
            while(left<=right)
            {
                int middle = (left+right)/2;
                if(numbers[middle] == t) return new int[]{i+1,middle+1};
                else if(t>numbers[middle]) left = middle+1;
                else right =middle-1;
            }
            
        }
        return new int[]{-1,-1};
    }
}