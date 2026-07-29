class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        dfs(nums, 0, result);
        return result;
    }


    private void dfs(int[] nums, int j, List<List<Integer>> res) {
        if(j == nums.length) {
            res.add(Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList()));
            return;
        }

        for(int i=j; i<nums.length; i++) {
            if (i > j && nums[j] == nums[i]) continue;
            swap(nums, i, j);
            dfs(nums, j+1, res);
            swap(nums, i, j);
        }
        
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}