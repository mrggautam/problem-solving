class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int i, int j) {

        if(s.length() == i || p.length() == j) {
             if(s.length() == i && p.length() == j) {
                return true;
             }
             if(s.length() == i) {
                for(int k=j; k<p.length(); k++) {
                    if(p.charAt(k) != '.' && p.charAt(k) != '*' ) {
                        return false;
                    }
                }
                return true;
             }
             return false;
        }


        boolean match = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            match = isMatch(s, p, i+1, j+1);
        }
        
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
             match = match || isMatch(s, p, i, j+2);
             if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                match = match || isMatch(s, p, i+1, j);
             }
        }

        return match;
    }
}
