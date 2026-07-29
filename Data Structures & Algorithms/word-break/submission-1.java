class Solution {
    Set<String> dictionary;
    Boolean[][] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        dictionary = new HashSet<>(wordDict);
        int n = s.length();
        memo = new Boolean[n+1][n+1];
        return wordBreak(s, 0, 0);
    }

    public boolean wordBreak(String str, int s, int e) {
        if(s == e && e >= str.length() ) {
            return true;
        }
        if(e > str.length()) {
            return false;
        }
        if(memo[s][e] != null) {
            return memo[s][e];
        }
        if(dictionary.contains(str.substring(s, e))) {
            memo[s][e] = wordBreak(str, e, e) || wordBreak(str, s, e+1);
            return memo[s][e];
        }

        memo[s][e] = wordBreak(str, s, e+1);
        return memo[s][e];
    }
}
