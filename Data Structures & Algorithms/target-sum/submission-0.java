class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        return findTargetSumWays(nums, 0, target);
        
    }


    public int findTargetSumWays(int[] nums, int i, int target) {
        if(i==nums.length) {
            if(target == 0) {
                return 1;
            }
            return 0;
        }
        

        int sum = findTargetSumWays(nums, i+1, target+nums[i]);
        int diff = findTargetSumWays(nums, i+1, target-nums[i]);

        return sum + diff;

    }
}
