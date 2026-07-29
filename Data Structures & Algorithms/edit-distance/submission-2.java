class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()][word2.length()];
        return minDistance(word1, word2, 0, 0);
    }

    public int minDistance(String word1, String word2, int i, int j) {
        if(word1.length() == i) {
            return word2.length() - j;
        }
        if(word2.length() == j) {
             return word1.length() - i;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int minDis = Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)) {
            minDis = minDistance(word1, word2, i+1, j+1);
        } else {
            //insert
            minDis = Math.min(minDis, minDistance(word1, word2, i, j+1)+1);
             //delete
            minDis = Math.min(minDis, minDistance(word1, word2, i+1, j)+1);
             //replace
            minDis = Math.min(minDis, minDistance(word1, word2, i+1, j+1)+1);
        }

        dp[i][j] = minDis;
        return dp[i][j];
    }
}
