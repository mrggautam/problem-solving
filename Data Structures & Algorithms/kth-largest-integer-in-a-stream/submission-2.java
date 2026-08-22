class KthLargest {

    PriorityQueue<Integer> pq; //minq
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.pq= new PriorityQueue();

        for(int num: nums) {
            add(num);
        }
        
    }
    
    public int add(int val) {
        if(pq.size() < k) {
            pq.add(val);
        } else if(pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
