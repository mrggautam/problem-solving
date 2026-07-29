class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<2) {
            return num[0];
        }
        int prev2 = nums[0];
        int prev1 = nums[1];

        for(int i=2;i<n;i++) {
            int curr = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(prev1, prev2);   
    }
}
