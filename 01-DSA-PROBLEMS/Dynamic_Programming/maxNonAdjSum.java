package Dynamic_Programming;

import java.util.Arrays;

public class maxNonAdjSum {
    public static void main(String[] args) {
        int[] arr={2,4,7,3,11,9,6};
        int ans=Integer.MIN_VALUE;
        int[]dp= new int[arr.length+1];
        Arrays.fill(dp, -1);
        System.out.println(solverecf(arr,ans,arr.length-1));
        System.out.println(solvemem(arr,arr.length-1, dp));
        System.out.println(solvedp(arr,arr.length-1, dp));
        System.out.println(solveSpace(arr));
    }
    static void solverecf(int[]arr,  int ans, int i){
        // int ans= Integer.MIN_VALUE;
        if(i<0) return ;
        if(i==0) return;
        //include element, after 1skip
        // ans= ans+arr[i];
      int  left=solverecf(arr, ans+arr[i], i-2);
        //exclude element, after 1skip
      int right= solverecf(arr,ans+0, i-1)+0;
        ans=Math.max(left, right);
        // return ans;
    }
   
     static int solvemem(int[] arr, int n, int[] dp){
        if(n<0) return 0;
        if(n==0) return arr[0];
        if(dp[n]!=-1){
            return dp[n];
        }
        //include
      int left= solvemem(arr, n-2, dp)+ arr[n];
      //exclude
      int right= solvemem(arr, n-1, dp);
       dp[n]= Math.max(left,right);
       return dp[n];
     }
     static int solvedp(int[]arr, int n,  int[]dp){
        if(n<0) return 0;
        if(n==0) return arr[0];
        
        dp[0]=arr[0];
        for(int i=1; i<n; i++){
            int left= arr[0]+ dp[n-2];
            int right=0+ dp[n-1];
            dp[i]=Math.max(left, right);
        }
        return dp[n];       
     }
     static int solveSpace(int[] arr){
        int n= arr.length;
        int prev2=0;
        int prev1=arr[0];
        for(int i=1; i<n; i++){
            int include= prev2+ arr[i];
            int exclude= prev1+0;
            int ans=Math.max(include, exclude);
            prev2= prev1;
            prev1= ans;
        }
        return prev1;
     }
}
