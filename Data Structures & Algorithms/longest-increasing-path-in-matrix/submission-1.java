class Solution {
    int[][] dirs; 
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        dp = new int[m][n];
        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};
        int result=0;

        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
               result = Math.max(result, longestIncreasingPath(matrix, i, j)+1) ;
            }
        }   
        return result;  
    }

    public int longestIncreasingPath(int[][] matrix, int i, int j) {
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int result = 0;
        for(int k=0; k<dirs.length; k++) {
            int newI = i+dirs[k][0];
            int newJ = j+dirs[k][1];
            if(isSafe(newI, newJ, matrix) && matrix[i][j] < matrix[newI][newJ]) {
                int temp = longestIncreasingPath(matrix, newI, newJ) + 1;
                result = Math.max(result, temp);
            }
        }

        dp[i][j] = result;
        return dp[i][j];
    }

    private boolean isSafe(int i, int j, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        return i < m && i >=0 
            && j < n && j >=0 
            && matrix[i][j] >= 0;
    }
}
