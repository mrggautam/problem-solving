class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        dfs(n, k, 1, new ArrayList(), result);
        return result;
        
    }

    private void dfs(int n, int k, int j, List<Integer> subset, List<List<Integer>> res) {
        if(subset.size() == k) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i=j; i<=n; i++) {
            subset.add(i);
            dfs(n, k, i+1, subset, res);
            subset.remove(subset.size()-1);
        }
        
    }
}