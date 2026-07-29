class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //int[] dp = new int[n];
        int prev2 =cost[n-1];
        int prev1 =cost[n-2];
        for(int i=n-3; i>=0; i--) {
            int curr = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
        
    }
}
