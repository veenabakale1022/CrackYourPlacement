import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            int index = Math.abs(num) - 1; // Get the index (1-based) corresponding to the number
            
            // Mark the number at the index as negative to indicate it has been seen
            if (nums[index] < 0) {
                result.add(Math.abs(num)); // If it's negative, it's a duplicate
            } else {
                nums[index] = -nums[index];
            }
        }
        
        // Restore the original array (optional)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        FindDuplicatesInArray solution = new FindDuplicatesInArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 1};
        List<Integer> duplicates = solution.findDuplicates(nums);
        System.out.println("Duplicates in the array: " + duplicates);
    }
}
