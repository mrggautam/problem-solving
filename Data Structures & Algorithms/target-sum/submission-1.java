class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).map(i -> Math.abs(i)).sum();
        dp = new int[nums.length+1][target+total+1];
        for(int i=0; i< nums.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findTargetSumWays(nums, 0, target);
        
    }


    public int findTargetSumWays(int[] nums, int i, int target) {
        if(i==nums.length) {
            if(target == 0) {
                return 1;
            }
            return 0;
        }

        if(dp[i][target] != -1) {
            return dp[i][target];
        }

        int sum = findTargetSumWays(nums, i+1, target+nums[i]);
        int diff = findTargetSumWays(nums, i+1, target-nums[i]);

        dp[i][target] = sum + diff;
        return dp[i][target];
    }
}
