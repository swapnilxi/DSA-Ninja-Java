class Solution {
    public int search(int[] nums, int target) {
            return searchFunc(nums, 0, nums.length-1, target);
    }

    public int searchFunc(int[] nums,int low, int high, int target) {
        if(low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return searchFunc(nums, 0, mid - 1, target);
        } else {
            return searchFunc(nums, mid + 1, high, target);
        }
    }
}
