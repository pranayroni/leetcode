class Solution {
    public boolean binary(int[] arr, int target)
    {
        int left =0;
        int right = arr.length-1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(arr[mid] == target) return true;
            if(target>arr[mid]) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
    public int smallestCommonElement(int[][] mat) {
        int res = -1;
        for(int i=0; i<mat[0].length; ++i)
        {
            res = mat[0][i];
            for(int j=1; j<mat.length; ++j)
            {
                if(!binary(mat[j],res))
                {
                    res = -1;
                    break;
                }
            }
            if(res!=-1) return res;
        }
        return -1;
    }
}