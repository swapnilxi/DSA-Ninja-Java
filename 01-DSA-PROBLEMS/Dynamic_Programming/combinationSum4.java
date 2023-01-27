public class combinationSum4 {
       public  static int solve(int[] nums, int target){
            //base case 
            if(target==0){
                return 1;
            }
            if(target<0){
                return 0;
            }
            int ans =0;
            for(int j=0; j<nums.length; ++j){
            ans= ans+solve(nums, target- nums[j]);
              }
            return ans;
        }
        // int solveMem(int[]  nums, int  tartget, int dp ){
            
        // }
        public static int combinationSum4(int[] nums, int target) {
           
           return solve(nums, target);   
        }
        public static void main(String[] args) {
            int[] nums = {1,2,3};
            int target= 4;
          System.out.println(combinationSum4(nums, target));;
        }
    }
    

