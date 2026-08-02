class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();
        int[] output = new int[nums.length-k+1];

        

        for(int i = 0; i < nums.length; i++) {
            while(deque.size() > 0 && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            
            while(deque.size() > 0 && nums[deque.peekLast()] <= nums[i]){
                    deque.pollLast();
            }
            deque.addLast(i);
            if(i-k+1 >=0) {
                output[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}
