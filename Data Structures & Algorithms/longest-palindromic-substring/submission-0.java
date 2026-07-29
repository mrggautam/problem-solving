class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        int max = 0;
        int start = 0;
        String res = "";
        for(int i=0; i<n; i++) {
            Pair<Integer, Integer> pair = getPalindromeForOdd(s, i);
            if(pair.getValue() > max) {
                max = pair.getValue();
                start = pair.getKey();
                res = s.substring(start, max);
            }
            pair = getPalindromeForEven(s, i);
            if(pair.getValue() > max) {
                max = pair.getValue();
                start = pair.getKey();
                res = s.substring(start, max+1);
            }
        }
        return res; 
    }

    public Pair<Integer, Integer> getPalindromeForOdd(String s, int middle) {
        int l=middle;
        int r=middle;
        int n=s.length();
        int size = 1;
        int start = -1;

        while(l>=0 & r<n) {
            if(s.charAt(l)==s.charAt(r)) {
                size = Math.max(size, r-l+1);
                start = l;
                l--;
                r++;
            } else {
                break;
            }
        }
        return new Pair(start, size);
    }

    public Pair<Integer, Integer> getPalindromeForEven(String s, int middle) {
        int l=middle;
        int r=middle+1;
        int n=s.length();
        int size = 0;
        int start = -1;

        while(l>=0 & r<n) {
            if(s.charAt(l) == s.charAt(r)) {
                size = Math.max(size, r-l+1);
                start = l;
                l--;
                r++;
            } else {
                break;
            }
        }
        return new Pair(start, size);
    }
}


//if i == j -> isPalindromin(i-1, j-1)
//else isPalindromic(i-1, j) || isPalindromic(i, j-1)

// isPalindromin(i, j) || isPalindromic(i-1, j) || isPalindromic(i, j-1)