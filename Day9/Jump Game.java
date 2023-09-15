class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Initialize the maximum reachable index
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If the current index is not reachable, return false
            }
            
            maxReach = Math.max(maxReach, i + nums[i]); // Update the maximum reachable index
        }
        
        return true; // If you can reach the end, return true
    }
}
