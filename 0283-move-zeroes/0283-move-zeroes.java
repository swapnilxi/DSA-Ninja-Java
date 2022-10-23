class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int k = 0, n= nums.length;
        //k is count of non-neg
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        while (k < n) {
            nums[k] = 0;
            k++;
        }
    }
}