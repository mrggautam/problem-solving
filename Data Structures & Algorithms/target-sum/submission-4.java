class Solution {
    int[][] dp;
    int total=0;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).map(i -> Math.abs(i)).sum();
        total = total + Math.abs(target);
        dp = new int[nums.length+1][2*total+1];
        for(int i=0; i< nums.length+1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
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

        if(dp[i][total+target] != Integer.MIN_VALUE) {
            return dp[i][total+target];
        }

        int sum = findTargetSumWays(nums, i+1, target+nums[i]);
        int diff = findTargetSumWays(nums, i+1, target-nums[i]);

        dp[i][total+target] = sum + diff;
        return dp[i][total+target];
    }
}
