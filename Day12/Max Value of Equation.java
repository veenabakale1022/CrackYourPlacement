import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int maxVal = Integer.MIN_VALUE;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Remove points that are out of range (xi - xj) > k
            while (!deque.isEmpty() && x - deque.peekFirst()[0] > k) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                // Calculate the equation value and update the maximum
                int equationValue = deque.peekFirst()[1] + y + x - deque.peekFirst()[0];
                maxVal = Math.max(maxVal, equationValue);
            }

            // Maintain the deque in decreasing order of (yi - xi)
            while (!deque.isEmpty() && y - x >= deque.peekLast()[1] - deque.peekLast()[0]) {
                deque.pollLast();
            }

            deque.offerLast(new int[]{x, y});
        }

        return maxVal;
    }
}
