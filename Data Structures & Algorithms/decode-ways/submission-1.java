class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n];
        if(s.charAt(0) > '0') {
            dp[0]=1;
        }
    

        for(int i=1; i<n; i++) {
           /* if(s.charAt(i)=='0' && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')) {
                    dp[i] = dp[i-1];
            } else */

             dp[i] = dp[i-1]; 
            
            if ((s.charAt(i-1) == '1' && s.charAt(i) >= '1' && s.charAt(i) <= '9') || 
                       (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                           dp[i] = dp[i]+1;
                       }
        }

        return dp[n-1];
        
    }
}
