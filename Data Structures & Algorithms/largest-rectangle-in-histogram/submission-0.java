class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Pair<Integer, Integer>> stack = new Stack();
        int result = 0;

        for(int i=0; i<n; i++) {
            int poppedIndex = i;
            while(!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> popped = stack.pop();
                poppedIndex = popped.getKey();
                result = Math.max(result, (i-popped.getKey())*popped.getValue());

            }
            stack.push(new Pair(poppedIndex, heights[i]));
        }

        while(!stack.isEmpty()) {
            Pair<Integer, Integer> popped = stack.pop();
            result = Math.max(result, (n-popped.getKey())*popped.getValue());
        }

        return result;
        
    }
}
