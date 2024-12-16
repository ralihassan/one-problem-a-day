import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    public static void main(String[] args) {
        testKthLargest();
    }

    public static void testKthLargest() {
        // Test case 1: Basic functionality
        KthLargest kthLargest1 = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest1.add(3) == 4 ? "Passed" : "Failed"); // return 4
        System.out.println(kthLargest1.add(5) == 5 ? "Passed" : "Failed"); // return 5
        System.out.println(kthLargest1.add(10) == 5 ? "Passed" : "Failed"); // return 5
        System.out.println(kthLargest1.add(9) == 8 ? "Passed" : "Failed"); // return 8
        System.out.println(kthLargest1.add(4) == 8 ? "Passed" : "Failed"); // return 8

        // Test case 2: All elements are the same
        KthLargest kthLargest2 = new KthLargest(4, new int[] { 7, 7, 7, 7, 8, 3 });
        System.out.println(kthLargest2.add(2) == 7 ? "Passed" : "Failed"); // return 7
        System.out.println(kthLargest2.add(10) == 7 ? "Passed" : "Failed"); // return 7
        System.out.println(kthLargest2.add(9) == 7 ? "Passed" : "Failed"); // return 7
        System.out.println(kthLargest2.add(9) == 8 ? "Passed" : "Failed"); // return 8

        // Test case 3: Empty initial array
        KthLargest kthLargest3 = new KthLargest(1, new int[] {});
        System.out.println(kthLargest3.add(1) == 1 ? "Passed" : "Failed"); // return 1
        System.out.println(kthLargest3.add(-1) == 1 ? "Passed" : "Failed"); // return 1
        System.out.println(kthLargest3.add(0) == 1 ? "Passed" : "Failed"); // return 1
        System.out.println(kthLargest3.add(2) == 2 ? "Passed" : "Failed"); // return 2

        // Test case 4: k is larger than the number of elements
        KthLargest kthLargest4 = new KthLargest(5, new int[] { 2, 3 });
        System.out.println(kthLargest4.add(4) == 2 ? "Passed" : "Failed"); // return 2
        System.out.println(kthLargest4.add(5) == 2 ? "Passed" : "Failed"); // return 2
        System.out.println(kthLargest4.add(10) == 2 ? "Passed" : "Failed"); // return 3
        System.out.println(kthLargest4.add(9) == 3 ? "Passed" : "Failed"); // return 4
    }

    Queue<Integer> pq = new PriorityQueue<>();
    int size = 0;

    public KthLargest(int k, int[] nums) {
        size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < size) {
            pq.add(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }

}
