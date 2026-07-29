class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum%k > 0) {
            return false;
        }
        nums = Arrays.stream(nums)
        .boxed()
        .sorted(Collections.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
        return dfs(nums, new boolean[n], sum/k, k, 0, 0);
    }


    private boolean dfs(int[] nums, boolean[] used, int target,  int k, int currentSum, int start) {
        if(k == 0) {
            return true;
        }
        if(currentSum == target) {
            return dfs(nums, used, target, k-1, 0, 0);
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