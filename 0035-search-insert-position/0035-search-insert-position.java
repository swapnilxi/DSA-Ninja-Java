class Solution {
    public int searchInsert(int[] nums, int target) {
        int s=0;
        int e= nums.length;
            
   while(s<e){
         int mid= s+ (e-s)/2; 
       if(nums[mid] > target) {
                e = mid; // left // check this line 
            } else if(nums[mid] < target) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
     
         
        
        return s;
    }
}



