/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) ==target) return 0;
        int left =0;
        int right =target - reader.get(0);
        while(left<=right)
        {
            int middle = (left+right)/2;
            if(reader.get(middle) == target) return middle;
            else if(target>reader.get(middle)) left = middle+1;
            else right = middle-1;
        }
        
        return -1;
    }
}