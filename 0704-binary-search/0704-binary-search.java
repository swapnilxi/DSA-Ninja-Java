class Solution {
    public int search(int[] nums, int target) {
        int e = nums.length - 1;
        int s= 0;
        while(s <= e){
            int m = s + (e - s)/2;
            
            if(nums[m]>target){
                e= m - 1; //left
            }
            else if(nums[m]<target){
                s= m+1;//right
            }else{
                return m;
            }
        }
        return -1;
    }
}      
  