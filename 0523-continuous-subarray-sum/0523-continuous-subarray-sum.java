class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
		
		// Map<remainder, index>
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);     // Why? Find the answer below
        
        int currSum = 0;    // This would be our running sum

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int rem = 0;

            rem = currSum % k;      // k can't be 0 when we do a number % k

            if (map.containsKey(rem)) {         // if that remainder already exists
                if (i - map.get(rem) > 1) {     // Length/difference checking Step
                    return true;                // and if the diff between the indices of the same remainder > 1, we get our answer
                }
            }

            map.putIfAbsent(rem, i);            // else we put that remainder along with its index in the map

            // we don't do map.put(rem, i) because it'll overwrite the old index (value) for the same rem (key).
            // using a 'putIfAbsent' will create a new unique map which we want.
        }

        return false;
    }
}
