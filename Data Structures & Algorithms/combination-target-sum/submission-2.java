class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int j, int currSum, List<Integer> subset, List<List<Integer>> res) {
        if(currSum == target) {
           res.add(new ArrayList(subset));
           return;
        }

        for(int i=j; i<nums.length; i++) {
            if(currSum+nums[i] > target) {
                return;
            }
            subset.add(nums[i]);
            dfs(nums, target, i, currSum+nums[i], subset, res);
            subset.remove(subset.size()-1);
        }
    }
}
