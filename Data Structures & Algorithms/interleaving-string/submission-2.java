class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() == s3.length()) {
            dp = new Boolean[s1.length()+1][s2.length()+1];
            /*Arrays.fill(dp[0], true);
            for(int i=0; i<s1.length(); i++) {
                dp[i][0] = true;
            }*/
            return isInterleave(s1, s2, s3, 0, 0, "");
        }
        return false;
    }  


    public boolean isInterleave(String s1, String s2, String s3, int i, int j, String s4) {
            if(s3.equals(s4)) {
                return true;
            }
            if(i > s1.length() || j > s2.length()) {
                return false;
            }

            if(dp[i][j] != null) {
                return dp[i][j];
            }
            boolean isInterleave = false;

            if(i < s1.length() && s3.charAt(s4.length()) == s1.charAt(i)) {
                isInterleave = isInterleave(s1, s2, s3, i+1, j, s4 + s1.charAt(i));
            }  
            if(j < s2.length() && !isInterleave && s3.charAt(s4.length()) == s2.charAt(j)) {
                isInterleave = isInterleave(s1, s2, s3, i, j+1, s4 + s2.charAt(j)) ;
            }
            dp[i][j] = isInterleave;
            return dp[i][j];
    }
}
