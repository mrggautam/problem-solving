class Solution {
    private Set<String> resSet = new HashSet();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        dfs(nums, target, 0, 0, new ArrayList(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int j, int currSum, List<Integer> subset, List<List<Integer>> res) {
        if(currSum > target) {
            return;
        }

        if(currSum == target) {
            if(!resSet.contains(subset.toString())) {
                res.add(new ArrayList(subset));
                resSet.add(subset.toString());
            }
            return;
        }

        for(int i=j; i<nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, target, i+1, currSum+nums[i], subset, res);
            dfs(nums, target, i, currSum+nums[i], subset, res);
            subset.remove(subset.size()-1);
        }
    }
}
