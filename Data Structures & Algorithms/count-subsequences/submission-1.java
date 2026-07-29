class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return numDistinct2(s, t);
        //return numDistinct(s, t, 0, 0);
    }

      public int numDistinct2(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        //Arrays.fill(dp[0], 1);

        for(int i=0; i<=m; i++) {
            dp[i][0]=1;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; 
                }
                dp[i][j] += dp[i-1][j];
            }
        }

        return dp[m][n];
    }

    public int numDistinct(String s, String t, int i, int j) {
        if(i == s.length() || j == t.length()) {
            if(j == t.length()) {
                return 1;
            }
            return 0;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }
        
        int count = 0;
        if(s.charAt(i) == t.charAt(j)) {
            count = numDistinct(s, t, i+1, j+1);
        } 

        count += numDistinct(s, t, i+1, j);

        dp[i][j] = count;
        return dp[i][j];
    }
}
