class Solution {
    public void sortColors(int[] nums) {
         int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
        }
    }
    public static void swap (int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}


Less Time complexity

    class Solution {
    public void sortColors(int[] nums) {
       int counts[] = new int[3];
       for(int n : nums){
           counts[n]++;
       } 
       for(int countIndex = 0, numsIndex =0; countIndex < 3; countIndex++){
           for(int j =0; j<counts[countIndex]; j++){
               nums[numsIndex] = countIndex;
               numsIndex++;
           }
       }
    }
}
