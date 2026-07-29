class Solution {
    private Set<String> duplicateSet = new HashSet();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int j, int currSum, List<Integer> subset, List<List<Integer>> res) {
        if(currSum == target) {
            if(!duplicateSet.contains(subset.toString())) {
                res.add(new ArrayList(subset));
                duplicateSet.add(subset.toString());
            }
           return;
        }

        if(currSum > target ) {
            return;
        }

        for(int i=j; i<nums.length; i++) {
            if(currSum+nums[i] > target) {
                return;
            }
            subset.add(nums[i]);
            dfs(nums, target, i+1, currSum+nums[i], subset, res);
            subset.remove(subset.size()-1);
        }
    }
}
