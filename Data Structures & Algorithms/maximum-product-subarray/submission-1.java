class Solution {
    public int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        int zero = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(nums[i]== 0) {
                max = 1;
                min = 1;    
                zero = 0;  
            } else if(nums[i] > 0) {
                max = max*nums[i]; //-15
                min = min*nums[i]; //-100
            } else {
                int temp = max;
                max = min*nums[i]; //-3
                min = temp*nums[i]; //-24
            }
            result = Math.max(result, max);
        }
        if(zero == 0 && result ==1) {
                return 0;
        }
        return result;
    }
}
