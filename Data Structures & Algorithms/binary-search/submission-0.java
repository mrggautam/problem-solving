class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while(l < r) {
            int mid = (r+l)/2;
            if(nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return nums[r]==target?r:-1;
    }
}
