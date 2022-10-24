class Solution{
public int[] findErrorNums(int[] nums) {
		Set<Integer> s=new HashSet<>();
		int []arr=new int[2];
		for(int i=0;i<nums.length;i++) {
			if(s.contains(nums[i])) arr[0]=nums[i];
			s.add(nums[i]);
		}
		for(int i=0;i<nums.length;i++) if(!s.contains(i+1)) arr[1]=i+1;
		return arr;
    }
}