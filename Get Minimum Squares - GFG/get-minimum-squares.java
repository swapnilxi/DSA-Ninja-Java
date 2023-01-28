//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{

    public int solve(int n){
            int ans=n;
        if(n<0){
            return 0;
        }
        //base case
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        for(int a=1; a*a<n; ++a){
        int temp= a*a;
         ans=Math.min(ans,solve(n-temp)+1);  
        }
        return ans;   
    }
    int solveMem(int n, int[] dp){
        int ans=n;
         if(n<0){
            return 0;
        }
        //base case
        if(n==0){
            return 0;
        }
      
        if(dp[n]!=-1){
            return dp[n];
        }
        for(int a=1; a*a<=n; ++a){
        int temp= a*a;
      
         ans=Math.min(ans,1+solveMem(n-temp, dp)); 
  
        }
        dp[n]=ans;
        return dp[n];   
        
    }
    
    public int MinSquares(int n)
    {
        // Code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
       return solveMem(n,dp);
    }
}