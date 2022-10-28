class Solution {
    public int bsearch(int[] arr,int x)
    {
        Arrays.sort(arr);
        int left =0;
        int right = arr.length-1;
        while(left<=right)
        {
            int middle = (left+right)/2;
            if(arr[middle] == x) {System.out.println("Found: "+x); return x;}
            else if (x>arr[middle]) left = middle+1;
            else right = middle-1;
        }
        return -1;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums1.length; i++)
        {
            if(!set.contains(nums1[i]) && bsearch(nums2,nums1[i]) != -1)
            {
                set.add(nums1[i]);
            }
        }
        int[] res = new int[set.size()];
        int i= 0;
        for(Integer x : set) res[i++] = x;
        return res;
        
        
    }
}