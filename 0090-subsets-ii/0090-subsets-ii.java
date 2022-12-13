class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        subsequence(0, nums, list , ans);
        return ans;
    }
    static void subsequence(int i,int[] arr, List<Integer> list, List<List<Integer>> ans){
        if(ans.contains(list)) return;
        if(i==arr.length){
        ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        subsequence(i+1, arr, list, ans);
        list.remove(list.size()-1);
        subsequence(i+1, arr, list, ans);
    }


}