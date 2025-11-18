class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int size;
    double median;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        minHeap = new PriorityQueue<>();
        size=0;
    }

    
    public void addNum(int num) {
        minHeap.add(num);
        size++;
        balance();
        median =  getMedian();
        // System.out.println(minHeap);
        // System.out.println(maxHeap+"n");
    }
    
    public double findMedian() {
        return median;
    }

    public double getMedian() {
        if(size%2==0){
            return ((double) maxHeap.peek()+ (double) minHeap.peek())/2 ;
        }
        else {
            return (double) maxHeap.peek();
        }
    }

    public void balance(){
        if(size%2==0 && maxHeap.peek()>minHeap.peek()){
            maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }
        if(size%2!=0){
            maxHeap.add(minHeap.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */