import java.util.HashMap;
import java.util.Map;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         int[] prefixSum = new int[nums.length + 1];
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // Initialize with a remainder of 0 (no prefix sum)

        int count = 0; // Initialize the count of subarrays with sum divisible by K

        for (int i = 0; i < nums.length; i++) {
            // Calculate the prefix sum
            prefixSum[i + 1] = prefixSum[i] + nums[i];

            // Calculate the remainder after dividing the prefix sum by K
            int remainder = (prefixSum[i + 1] % k + k) % k;

            // If the same remainder has been seen before, add its count to the result
            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            // Update the remainder count map
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;

        
    }
}
