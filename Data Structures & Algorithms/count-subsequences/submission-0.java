class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return numDistinct(s, t, 0, 0);
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
