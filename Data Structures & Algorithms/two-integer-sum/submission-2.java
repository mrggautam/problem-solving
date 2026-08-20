class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[][] A=new int[nums.length][2];

        for(int i=0; i<nums.length;i++) {
            A[i][0]=nums[i];
            A[i][1]=i;
        }

        Arrays.sort(A, Comparator.comparingInt(a-> a[0]));

        int l=0;
        int h=nums.length-1;

        while(l<h) {
            int sum = A[l][0] + A[h][0];
            if(sum<target){
                l++;
            } else if(sum>target) {
                h--;
            } else {
                int a = Math.min(A[l][1], A[h][1]);
                int b = Math.max(A[l][1], A[h][1]);
                return new int[]{a, b};
            }
        }
        return new int[]{-1, -1};
    }
}
