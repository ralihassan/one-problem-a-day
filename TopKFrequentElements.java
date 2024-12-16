import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        testTopKFrequent();
    }

    public static void testTopKFrequent() {
        TopKFrequentElements main = new TopKFrequentElements();

        // Test case 1: Basic functiona lity
        int[] nums1 = { 1, 1, 1, 2, 2, 3 };
        int k1 = 2;
        List<Integer> result1 = main.topKFrequent(nums1, k1);
        System.out.println("Test case 1: " + (result1.equals(Arrays.asList(2, 1)) ? "Passed" : "Failed"));

        // Test case 2: All elements are the same
        int[] nums2 = { 1, 1, 1, 1, 1 };
        int k2 = 1;
        List<Integer> result2 = main.topKFrequent(nums2, k2);
        System.out.println("Test case 2: " + (result2.equals(Arrays.asList(1)) ? "Passed" : "Failed"));

        // Test case 3: k equals the number of unique elements
        int[] nums3 = { 1, 2, 3, 4, 5 };
        int k3 = 5;
        List<Integer> result3 = main.topKFrequent(nums3, k3);
        System.out.println("Test case 3: " + (result3.equals(Arrays.asList(1, 2, 3, 4, 5)) ? "Passed" : "Failed"));

        // Test case 4: Single element array
        int[] nums4 = { 1 };
        int k4 = 1;
        List<Integer> result4 = main.topKFrequent(nums4, k4);
        System.out.println("Test case 4: " + (result4.equals(Arrays.asList(1)) ? "Passed" : "Failed"));

        // Test case 5: Array with negati ve numbers
        int[] nums5 = { -1, -1, -2, -2, -3 };
        int k5 = 2;
        List<Integer> result5 = main.topKFrequent(nums5, k5);
        System.out.println("Test case 5: " + (result5.equals(Arrays.asList(-1, -2)) ? "Passed" : "Failed"));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int key : freq.keySet()) {
            if (pq.size() < k) {
                pq.add(new int[] { key, freq.get(key) });
            } else if (pq.peek()[1] < freq.get(key)) {
                pq.poll();
                pq.add(new int[] { key, freq.get(key) });
            }
        }

        return pq.stream().map(pair -> pair[0]).collect(Collectors.toList());
    }

}
