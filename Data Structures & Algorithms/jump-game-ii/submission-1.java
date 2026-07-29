class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int goal = n-1;
        int jumps = 0;

        for(int i=n-2; i>=0; i--) {
            int min=n;
            int j=i;
            while(j>=0) {
                if(j+nums[j]>=goal) {
                    min= Math.min(min, j);
                }
                j--;
            }
            goal=min;
            i=goal;
            jumps++;
        }
        return jumps; 
    }
}
