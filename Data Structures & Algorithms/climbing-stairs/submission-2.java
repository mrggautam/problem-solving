class Solution {
    public int climbStairs(int n) {
        int res = 1;
        int prev = 1;
        int curr = 1;
        for(int i=2; i<=n;i++) {
                res = prev + curr;
                prev = curr;
                curr = res;
        }
        return res;
    }
}