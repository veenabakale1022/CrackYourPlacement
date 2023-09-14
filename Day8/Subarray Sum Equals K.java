import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // Initialize variables to keep track of the cumulative sum and count of subarrays.
        int sum = 0;
        int count = 0;

        // Create a HashMap to store the cumulative sum and its frequency.
        HashMap<Integer, Integer> sumFrequencyMap = new HashMap<>();
        // Initialize the map with a sum of 0 (to handle subarrays that start from the beginning).
        sumFrequencyMap.put(0, 1);

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Update the cumulative sum.
            sum += nums[i];

            // If the (sum - k) exists in the map, it means there is a subarray with sum k.
            if (sumFrequencyMap.containsKey(sum - k)) {
                count += sumFrequencyMap.get(sum - k);
            }

            // Update the sumFrequencyMap with the current cumulative sum.
            sumFrequencyMap.put(sum, sumFrequencyMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
