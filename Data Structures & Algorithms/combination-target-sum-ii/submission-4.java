class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, int target, int i, int currSum, List<Integer> subset, Set<List<Integer>> res) {
        if(currSum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if(currSum > target || i >= nums.length) {
            return;
        }

        subset.add(nums[i]);
        dfs(nums, target, i+1, currSum+nums[i], subset, res);
        subset.remove(subset.size()-1);

       
        dfs(nums, target, i+1, currSum, subset, res);
    }
}