class Solution {
    public int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;
        int n = nums.length;
        int result = nums[0];

        for(int i=0; i<n; i++) {
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(max*nums[i], min*nums[i]), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
