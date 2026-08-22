class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> stack = new Stack();
        int[] result = new int[n];

        for(int i = 0; i< n; i++) {
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
        
    }
}
