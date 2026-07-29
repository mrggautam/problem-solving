class Solution {
    Set<String> dictionary;
    Boolean[] memo;
    int t=0;
    public boolean wordBreak(String s, List<String> wordDict) {
        dictionary = new HashSet<>(wordDict);
        int n = s.length();
        memo = new Boolean[n+1];
        for (int i = 0; i < wordDict.size(); i++) {
            t = Math.max(t, wordDict.get(i).length());
        }
        return wordBreak(s, 0);
    }

     public boolean wordBreak(String str, int i) {
        if(i == str.length()) {
            return true;
        }
        if(memo[i] != null) {
            return memo[i];
        }

        for(int j=i; j < Math.min(i+t,str.length()); j++) {
            String word = str.substring(i, j+1);
            if(dictionary.contains(word)) {
               if(wordBreak(str, j+1)) {
                 memo[i] = true;
                 return memo[i];
               } else {
                 memo[j] = false;
               }
            }
        }

        memo[i] = false;
        return memo[i];
    }

   /* public boolean wordBreak(String str, int s, int e) {
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
    } */
}
