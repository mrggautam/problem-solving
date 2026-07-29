class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+2][2];

        /*
        for(int i=0; i<prices.length; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][prices.length+1]=0;
        }*/

        //return maxProfit(prices, 0, 1);
        return maxProfit2(prices);
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
        dp[day][buy] = profit;

        return dp[day][buy];
    }

    public int maxProfit2(int[] prices) {
        int days = prices.length;
        for(int day=days-1; day>=0; day--) {
            for(int buy = 0; buy<2; buy++) {
                int profit = 0;
                if(buy == 1) {
                    profit = Math.max(-prices[day]+dp[day+1][0], dp[day+1][buy]);
                } else {
                    profit = Math.max(dp[day+1][buy], prices[day]+dp[day+2][1]);
                }
                dp[day][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
