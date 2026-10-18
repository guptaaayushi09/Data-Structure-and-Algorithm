class MedianFinder {
    PriorityQueue<Integer> minHeapRight;
    PriorityQueue<Integer> maxHeapLeft;
    public MedianFinder() {
        minHeapRight = new PriorityQueue<>();
        maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeapLeft.offer(num);
        minHeapRight.offer(maxHeapLeft.poll());

       if(minHeapRight.size() > maxHeapLeft.size()) maxHeapLeft.offer(minHeapRight.poll());

    }
    
    public double findMedian() {
     return maxHeapLeft.size() > minHeapRight.size() ? maxHeapLeft.peek() : (maxHeapLeft.peek() + minHeapRight.peek())/2.0;
    }
}
