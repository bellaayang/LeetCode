/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> maxHeap; // small heap
    PriorityQueue<Integer> minHeap; // large heap

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if ((maxHeap.size() - minHeap.size() > 1) || (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())) {
            int cur = maxHeap.poll();
            minHeap.add(cur);
        }

        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

