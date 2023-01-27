import java.security.DrbgParameters.Capability;
import java.util.ArrayList;
import java.util.Arrays;
public class Knapsack {
    static int solve(int W, int index,  ArrayList<Integer> weight,  ArrayList<Integer> value){
        //W= maximum weight
        //base Case
        if(index==0){
            if (weight.get(0)< W){
                return value.get(0);
            }
            else return 0;
        }
        int include=0;
        int exclude=0;
        if(weight.get(index)< W){
            include= value.get(index)+  solve(W-weight.get(index), index-1 , weight, value);
        }
        exclude = solve(W, index-1 , weight, value);
        int ans=Math.max(include, exclude);
        return ans;
    }
    private static int solveMem(int W, int index, ArrayList<Integer> weight, ArrayList<Integer> value, int[][] dp) {
        if(index==0){
            if (weight.get(0)< W){
                return value.get(0);
            }
            else return 0;
        }
        if(dp[index][W]!=-1){
            return dp[index][W];
        }
        int include=0;
        int exclude=0;
        if(weight.get(index)< W){
            include= value.get(index)+  solve(W-weight.get(index), index-1 , weight, value);
        }
        exclude = solve(W, index-1 , weight, value);
       dp[index][W]=Math.max(include, exclude);
        return dp[index][W];
    }

    private static int solveDP(int W, int n_index, ArrayList<Integer> weight, ArrayList<Integer> value) {
        //2D Dp array
        int[][] dp= new int[n_index+1][W+1];
        // Arrays.stream(dp).forEach(a-> Arrays.fill(a,-1));

        //analyse base case
        for(int item_weight= weight.get(0); item_weight<=W; ++item_weight){
            if(weight.get(0)<=W){
            dp[0][item_weight]=value.get(0);
            }else dp[0][item_weight]=0;
        }
        
        //taking care of remaining recursive calls
        int include=0; 
        int exclude=0;
        //index for each->i // capacity for each->w
        for(int i=1;i<n_index; ++i){
            for(int w=0;w<=W;++w){
                // include= value.get(index)+  solve(W-weight.get(index), index-1 , weight, value)
                if(weight.get(i)<=w){
                include= value.get(i)+dp[i-1][w-weight.get(i)];
                }
                exclude=  dp[i-1][w];
                dp[n_index][w]= Math.max(exclude, include);
            }
        }
        return dp[n_index-1][W];
       
    }


    public static void main(String[] args) {
        int W=12;// capcity of knapsack 
        int n=3 ; //number of items 
        int[][] dp= new int[n+1][W+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        // for (int[] row : dp){
        // Arrays.fill(row, -1);
    // System.out.println(Arrays.deepToString(dp));
    // }
        ArrayList<Integer> weight= new ArrayList<>();
        //w1, w2, w3  // weight of items 
        weight.add(1);
        weight.add(4);
        weight.add(5);
        weight.add(9);
        ArrayList<Integer> value=new ArrayList<>();
        //v1, v2, v3 // value of item
        value.add(3);
        value.add(9);
        value.add(6);
        value.add(35); 
    // Maximum value that theif can steal
    // int MaxValue= solveMem(W, n , weight, value,dp);
    int MaxValue= solveDP(W, n , weight, value);
       System.out.println(MaxValue);
    }
    
}
