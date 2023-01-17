

import java.util.Arrays;

public class coinChange {
public static void main(String[] args) {
      int amount =11;
      int[] coins={1,2,5};
      int ans= Integer.MAX_VALUE;
      int[] dp= new int[amount+1];
      Arrays.fill(dp,-1);
    System.out.println(recSolve(coins, amount, ans));
    System.out.println(memSolve(coins, amount, ans, dp));
    System.out.println(dpSolve(coins, amount, ans, dp));
}

    static int dpSolve(int[] coins, int amount, int ans, int[] dp){
      if(amount==0) return 0;
         if(amount<0) return Integer.MAX_VALUE;
         if(dp[amount]!=-1){
            return dp[amount];
         }
        //coins needed to get amount 0
        dp[0]=0;
       for(int i=1; i<amount; ++i){
           for(int j=0; j<coins.length; ++j){
                if(i-coins[j]>=0 && dp[i-coins[j]]!= Integer.MAX_VALUE){
                dp[i]=Math.min(dp[i], 1+dp[i-coins[j]]);
                }
            }
        }
    if(dp[amount]==Integer.MAX_VALUE) return -1;
    return dp[amount];
    
    }
 
    static int memSolve(int[] coins, int amount, int ans, int[] dp){
         if(amount==0) return 0;
         int minCount= Integer.MAX_VALUE;
         if(amount<0) return Integer.MAX_VALUE;
         if(dp[amount]!=-1){
            return dp[amount];
         }
        for(int i=0; i<coins.length; ++i){
            ans= memSolve(coins, amount- coins[i], ans,dp);
        }
        minCount =Math.min(ans+1, minCount);
        dp[amount]=minCount;
        return dp[amount];
    }
    
    static int recSolve(int[] coins, int amount, int ans){
        int minCount= Integer.MAX_VALUE;
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        for(int i: coins){
        ans= recSolve(coins, amount- i, ans);
        }
        if(ans!= Integer.MAX_VALUE){
            minCount=Math.min(ans+1, minCount); 
            return minCount;
        }
        return -1;
    }
}
    

