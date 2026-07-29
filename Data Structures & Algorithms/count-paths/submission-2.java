class Solution {
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];

        Arrays.fill(pre, 1);

        for(int i=m-2; i>=0; i--) {
             int[] curr = new int[n];
             curr[n-1]=1;
            for(int j=n-2; j>=0; j--) {
                curr[j] = pre[j]+curr[j+1];
            }
            pre = curr;
        }

        return pre[0];
    }
}
