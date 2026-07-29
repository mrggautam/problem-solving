class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();
        if(sum%4 != 0) {
            return false;
        }
        return dfs(matchsticks, new boolean[n], sum/4, 4, 0, 0);
    }


    private boolean dfs(int[] nums, boolean[] used, int target,  int k, int currentSum, int start) {
        if(currentSum == target) {
            if(k == 1) {
                return true;
            }
            return dfs(nums, used, target, k-1, 0, start);
        }

        for(int i=start; i< nums.length; i++) {
            if(used[i] || currentSum+nums[i] > target) {
                continue;
            }
            used[i] = true;
            if(dfs(nums, used, target, k, currentSum+nums[i], i+1)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}