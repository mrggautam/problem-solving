class Solution {
    public int trap(int[] height) {

        int s = 0;
        int e = height.length-1;

        int maxL = height[s];
        int maxR = height[e];

        int result = 0;

        while(s<e) {
            if(maxL < maxR) {
                s++;
                result += Math.max(0, maxL - height[s]);
                maxL = Math.max(maxL, height[s]);
            } else {
                e--;
                result += Math.max(0, maxR - height[e]);
                maxR = Math.max(maxR, height[e]);
            }
        }

        return result;
        
    }
}
