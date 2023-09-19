class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate left boundaries
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            leftBound[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for calculating right boundaries
        stack.clear();

        // Calculate right boundaries
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            rightBound[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate maximum rectangle area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightBound[i] - leftBound[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

        
    }
}
