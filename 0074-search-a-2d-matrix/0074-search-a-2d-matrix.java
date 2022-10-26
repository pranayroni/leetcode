class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length-1;
        int m = 0;
        while(l<=r)
        {
            m = (l+r)/2;
            System.out.println(m);
            if(target==matrix[m][0]) return true;
            else if(target<matrix[m][0]) r = m-1;
            else if(target>matrix[m][0]) 
            {
                
                int left = 0;
                int right = matrix[m].length-1;
                int middle = 0;
                while(left<=right)
                {
                    System.out.println(matrix[m][middle]);
                    middle = (left+right)/2;
                    if(matrix[m][middle] == target) return true;
                    else if(target>matrix[m][middle]) left = middle+1;
                    else if(target<matrix[m][middle]) right = middle-1;
                }
                l = m+1;
            }
        }
        return false;
    }
}