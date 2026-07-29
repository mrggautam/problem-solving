class Solution {
    int[][] dp;
    int result = 0;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+1][2];

        for(int i=0; i<prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxProfit(prices, 0, 1);
        //return result;
    }

    public int maxProfit(int[] prices, int day, int buy) {
        int profit = 0;
        if(day >= prices.length) {
            return 0;
        } 

        if(dp[day][buy] != -1) {
            return dp[day][buy];
        }

        if(buy == 1) {
            profit = Math.max(-prices[day]+maxProfit(prices, day+1, 0), maxProfit(prices, day+1, buy));
        } else {
            profit = Math.max(prices[day]+maxProfit(prices, day+2, 1), maxProfit(prices, day+1, buy));
        }

        profit = Math.max(0, profit);
        result = Math.max(result, profit);

        dp[day][buy] = profit;

        return dp[day][buy];
    }
}
