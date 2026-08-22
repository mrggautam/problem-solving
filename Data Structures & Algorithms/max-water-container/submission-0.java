class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int h=heights.length-1;
        int result =0;

        while(l<h) {
            int length = h - l;
            int height = Math.min(heights[l], heights[h]);
            result = Math.max(result, length*height);
            if(heights[l] < heights[h]) {
                l++;
            } else {
                h--;
            }
        }

        return result;
        
    }
}
