import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        testFindKthLargest();
    }

    public static void testFindKthLargest() {

        // Test case 1: Basic functionality
        int[] nums1 = { 3, 2, 1, 5, 6, 4 };
        int k1 = 2;
        int result1 = findKthLargest(nums1, k1);
        System.out.println("Test case 1: " + (result1 == 5 ? "Passed" : "Failed"));

        // Test case 2: Array with duplicates
        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;
        int result2 = findKthLargest(nums2, k2);
        System.out.println("Test case 2: " + (result2 == 4 ? "Passed" : "Failed"));

        // Test case 3: Single element array
        int[] nums3 = { 1 };
        int k3 = 1;
        int result3 = findKthLargest(nums3, k3);
        System.out.println("Test case 3: " + (result3 == 1 ? "Passed" : "Failed"));

        // Test case 4: Array with negative numbers
        int[] nums4 = { -1, -2, -3, -4, -5 };
        int k4 = 3;
        int result4 = findKthLargest(nums4, k4);
        System.out.println("Test case 4: " + (result4 == -3 ? "Passed" : "Failed"));

        // Test case 5: k is the size of the array
        int[] nums5 = { 7, 10, 4, 3, 20, 15 };
        int k5 = 6;
        int result5 = findKthLargest(nums5, k5);
        System.out.println("Test case 5: " + (result5 == 3 ? "Passed" : "Failed"));
    }

    public static int findKthLargest(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>(k);

        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.add(num);
            }
        }

        return pq.peek();
    }

}
