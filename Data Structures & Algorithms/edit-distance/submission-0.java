class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0);
    }

    public int minDistance(String word1, String word2, int i, int j) {
        if(word1.length() == i || word2.length() == j) {
            return Math.abs(i-j);
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

        return minDis;
    }
}
