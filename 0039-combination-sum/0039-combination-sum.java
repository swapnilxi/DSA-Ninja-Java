class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        isCombination(0,candidates,target,0,ans,list);
        return ans;
    }
    void isCombination(int start,int[] candidate,int target,int sum,List<List<Integer>> ans, List<Integer> list)
    {
        if(sum==target){
            ans.add(new ArrayList(list));
            return;
        }
        
        if(start>=candidate.length)
            return;
        
        if(sum>target)
            return;
        
        //include
        sum+=candidate[start];
        list.add(candidate[start]);
        isCombination(start,candidate,target,sum,ans,list);
        
        //exclude
        sum-=candidate[start];
        list.remove(list.size()-1);
        isCombination(start+1,candidate,target,sum,ans,list);
    }
}