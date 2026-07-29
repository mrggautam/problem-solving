class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int i, int currSum, List<Integer> subset, List<List<Integer>> res) {
        if(currSum == target) {
           res.add(new ArrayList(subset));
           return;
        }

        if(currSum > target || i >= nums.length) {
            return;
        }

        subset.add(nums[i]);
        dfs(nums, target, i, currSum+nums[i], subset, res);
        subset.remove(subset.size()-1);
        dfs(nums, target, i+1, currSum, subset, res);
        
        /*
        for(int i=j; i<nums.length; i++) {
            if(currSum+nums[i] > target) {
                return;
            }
            subset.add(nums[i]);
            dfs(nums, target, i, currSum+nums[i], subset, res);
            subset.remove(subset.size()-1);
        }*/
    }
}
