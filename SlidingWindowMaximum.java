import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        testMaxSlidingWindow();
    }

    public static void testMaxSlidingWindow() {
        SlidingWindowMaximum main = new SlidingWindowMaximum();

        // Test case 1: Basic functionality
        int[] input1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] expected1 = {3, 3, 5, 5, 6, 7};
        int[] result1 = main.maxSlidingWindow(input1, k1);
        System.out.println("Test case 1: " + (java.util.Arrays.equals(result1, expected1) ? "Passed" : "Failed"));

        // Test case 2: Single element window
        int[] input2 = {1, 3, 1, 2, 0, 5};
        int k2 = 1;
        int[] expected2 = {1, 3, 1, 2, 0, 5};
        int[] result2 = main.maxSlidingWindow(input2, k2);
        System.out.println("Test case 2: " + (java.util.Arrays.equals(result2, expected2) ? "Passed" : "Failed"));

        // Test case 3: Window size equals array length
        int[] input3 = {1, 3, 1};
        int k3 = 3;
        int[] expected3 = {3};
        int[] result3 = main.maxSlidingWindow(input3, k3);
        System.out.println("Test case 3: " + (java.util.Arrays.equals(result3, expected3) ? "Passed" : "Failed"));

        // Test case 4: All elements are the same
        int[] input4 = {2, 2, 2, 2, 2};
        int k4 = 2;
        int[] expected4 = {2, 2, 2, 2};
        int[] result4 = main.maxSlidingWindow(input4, k4);
        System.out.println("Test case 4: " + (java.util.Arrays.equals(result4, expected4) ? "Passed" : "Failed"));

        // Test case 5: Decreasing sequence
        int[] input5 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int k5 = 4;
        int[] expected5 = {9, 8, 7, 6, 5, 4};
        int[] result5 = main.maxSlidingWindow(input5, k5);
        System.out.println("Test case 5: " + (java.util.Arrays.equals(result5, expected5) ? "Passed" : "Failed"));

        // Test case 6: Increasing sequence
        int[] input6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k6 = 3;
        int[] expected6 = {3, 4, 5, 6, 7, 8, 9};
        int[] result6 = main.maxSlidingWindow(input6, k6);
        System.out.println("Test case 6: " + (java.util.Arrays.equals(result6, expected6) ? "Passed" : "Failed"));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length-k+1];

        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k-1) {
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }

        return res;        
    }

    public int[] maxSlidingWindowMap(int[] nums, int k) {
        int res[] = new int[nums.length-k+1];

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<k -1; i++) {
            pq.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (int i = k-1; i < nums.length; i++) {
            pq.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            
            while (map.get(pq.peek()) <= 0) {
                pq.poll();
            }

            res[i-k+1] = pq.peek();

            map.put(nums[i-k+1], map.get(nums[i-k+1])-1);
        }

        return res;        
    }

}
