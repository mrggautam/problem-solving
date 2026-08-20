class NumMatrix {

    int[][] matrix;
    int[][] matrixSum;

    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        this.matrix = matrix;
        this.matrixSum = new int[m+1][n+1];

        for(int i=0; i<m;i++) {
           int prefix=0;
           for(int j=0; j<n; j++) {
            prefix += matrix[i][j];
            int above = this.matrixSum[i][j+1];
            this.matrixSum[i+1][j+1]=prefix+above;
           }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottomright = matrixSum[row2+1][col2+1];
        int left = matrixSum[row2+1][col1];
        int above = matrixSum[row1][col2+1];
        int topleft = matrixSum[row1][col1];

        return bottomright - left - above + topleft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */