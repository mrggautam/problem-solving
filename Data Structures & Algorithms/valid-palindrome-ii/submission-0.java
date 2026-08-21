class Solution {
    public boolean validPalindrome(String s) {

        int l=0;
        int h=s.length()-1;

        while(l<h) {
            if(s.charAt(l) == s.charAt(h)) {
                l++;
                h--;
            } else {
                return isPalindrome(s, l+1, h) || isPalindrome(s, l, h-1);
            }
        }

        return true;
        
    }

     private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}