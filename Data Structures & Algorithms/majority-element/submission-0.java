class Solution {
    public int majorityElement(int[] nums) {

        int num=-1;
        int count=0;
        int i=0;

        while(i<nums.length) {
            if(num == nums[i]) {
                count++;
            } else if(count > 0) {
                count--;
            } else {
                num=nums[i];
                count++;
            }
            i++;
        }
        return num;
    }
}