class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>>ans = new ArrayList<>();
      List<Integer> list=new ArrayList<>();
      subs(ans, list, nums, 0);
      return ans;  
    }
    void subs(List<List<Integer>> ans, List<Integer> list, int[] nums, int start)  {
        if(start==nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[start]);
        subs(ans,list, nums, start + 1);
        list.remove(list.size() - 1);
       subs(ans,list, nums, start + 1);
    }
}