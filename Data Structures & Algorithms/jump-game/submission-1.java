class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <2) {
            return true;
        }
        int i=0;
        while(i < nums.length) {
            if(nums[i] == 0) {
                return false;
            }
            i = i + nums[i];
            if(i+1 >= nums.length) {
                return true;
            }
        }
        return false;
    }
}
