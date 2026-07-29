class Solution {
    Set<String> dictionary;
    public boolean wordBreak(String s, List<String> wordDict) {
        dictionary = new HashSet<>(wordDict);
        return wordBreak(s, 0, 0);
    }

    public boolean wordBreak(String str, int s, int e) {
        if(s == e && e >= str.length() ) {
            return true;
        }
        if(e > str.length()) {
            return false;
        }
        if(dictionary.contains(str.substring(s, e))) {
            return wordBreak(str, e, e) || wordBreak(str, s, e+1);
        }

        return wordBreak(str, s, e+1);
    }
}
