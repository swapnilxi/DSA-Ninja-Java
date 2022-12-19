class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set= new HashSet<Integer>();
           Set<Integer> set1= new HashSet<Integer>();
         
    
    for (int i : nums1) {
            set1.add(i);
        }
       for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set.add(nums2[i]);
            }
        }
        //storing result in Array 
        int[] finalResult = new int[set.size()];
        int index = 0;
        for (int value : set) {
            finalResult[index++] = value;
        }
        return finalResult;
    }
    
}