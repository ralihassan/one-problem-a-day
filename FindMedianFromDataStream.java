import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

    public static void main(String[] args) {
        testMedianFinder();
    }

    public static void testMedianFinder() {
        MedianFinder medianFinder = new FindMedianFromDataStream().new MedianFinder();

        // Test case 1: Adding a single number
        medianFinder.addNum(1);
        System.out.println("Test case 1: " + (medianFinder.findMedian() == 1.0 ? "Passed" : "Failed"));

        // Test case 2: Adding two numbers
        medianFinder.addNum(2);
        System.out.println("Test case 2: " + (medianFinder.findMedian() == 1.5 ? "Passed" : "Failed"));

        // Test case 3: Adding three numbers
        medianFinder.addNum(3);
        System.out.println("Test case 3: " + (medianFinder.findMedian() == 2.0 ? "Passed" : "Failed"));

        // Test case 4: Adding four numbers
        medianFinder.addNum(4);
        System.out.println("Test case 4: " + (medianFinder.findMedian() == 2.5 ? "Passed" : "Failed"));

        // Test case 5: Adding five numbers
        medianFinder.addNum(5);
        System.out.println("Test case 5: " + (medianFinder.findMedian() == 3.0 ? "Passed" : "Failed"));

        // Test case 6: Adding numbers in reverse order
        MedianFinder reverseOrderFinder = new Main().new MedianFinder();
        reverseOrderFinder.addNum(5);
        reverseOrderFinder.addNum(4);
        reverseOrderFinder.addNum(3);
        reverseOrderFinder.addNum(2);
        reverseOrderFinder.addNum(1);
        System.out.println("Test case 6: " + (reverseOrderFinder.findMedian() == 3.0 ? "Passed" : "Failed"));

        // Test case 7: Adding duplicate numbers
        MedianFinder duplicateFinder = new Main().new MedianFinder();
        duplicateFinder.addNum(2);
        duplicateFinder.addNum(2);
        duplicateFinder.addNum(2);
        System.out.println("Test case 7: " + (duplicateFinder.findMedian() == 2.0 ? "Passed" : "Failed"));
    }

    public class MedianFinder {
        
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        public MedianFinder() {
        }
    
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll()); 
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }
    
        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }

            return maxHeap.peek();
        }
    }

}
