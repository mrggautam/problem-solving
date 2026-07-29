class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if(sum%2 != 0) {
            return false;
        }

        int target = sum/2;
        int n=nums.length;
        memo = new Boolean[n+1][target+1];
        return dfs(nums, n-1, target);
        
    }

    public boolean dfs(int[] nums, int i, int target) {
        if(target == 0) {
            return true;
        }
        if(target < 0 || i < 0) {
            return false;
        }
        if(memo[i][target] != null) {
            return memo[i][target];
        }

        boolean skip = dfs(nums, i-1, target);
        boolean pick = dfs(nums, i-1, target - nums[i]);

        memo[i][target] = skip || pick;
        return memo[i][target];
    }
}
