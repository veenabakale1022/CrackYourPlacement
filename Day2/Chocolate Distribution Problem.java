class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize the minimum price to a large value
        int maxProfit = 0; // Initialize the maximum profit to 0

        for (int i = 0; i < prices.length; i++) {
            // Update the minimum price if we find a lower price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate the potential profit if we sell at the current price
            int potentialProfit = prices[i] - minPrice;
            // Update the maximum profit if the potential profit is higher
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
        }

        return maxProfit;
    }
}
