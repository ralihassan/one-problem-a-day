import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        Subsets main = new Subsets();
        main.testSubsets();
    }

    public void testSubsets() {
        // Test case 1: Empty array
        int[] nums1 = {};
        List<List<Integer>> expected1 = Arrays.asList(Arrays.asList());
        System.out.println("Test case 1: " + (subsets(nums1).equals(expected1) ? "Passed" : "Failed"));

        // Test case 2: Single element
        int[] nums2 = { 1 };
        List<List<Integer>> expected2 = Arrays.asList(Arrays.asList(),
                Arrays.asList(1));
        System.out.println("Test case 2: " + (subsets(nums2).equals(expected2) ? "Passed" : "Failed"));

        // Test case 3: Two elements
        int[] nums3 = { 1, 2 };
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(), Arrays.asList(1), Arrays.asList(2), Arrays.asList(1, 2));
        System.out.println("Test case 3: " + (subsets(nums3).equals(expected3) ? "Passed" : "Failed"));

        // Test case 4: Three elements
        int[] nums4 = { 1, 2, 3 };
        List<List<Integer>> expected4 = Arrays.asList(
                Arrays.asList(), Arrays.asList(1), Arrays.asList(2), Arrays.asList(1, 2),
                Arrays.asList(3), Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(1, 2, 3));
        System.out.println("Test case 4: " + (subsets(nums4).equals(expected4) ? "Passed" : "Failed"));

        // Test case 5: Duplicate elements
        int[] nums5 = { 1, 2, 2 };
        List<List<Integer>> expected5 = Arrays.asList(
                Arrays.asList(), Arrays.asList(1), Arrays.asList(2), Arrays.asList(1, 2),
                Arrays.asList(2, 2), Arrays.asList(1, 2, 2));
        System.out.println("Test case 5: " + (subsets(nums5).equals(expected5) ? "Passed" : "Failed"));

        System.out.println("All test cases for subsets completed!");
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        res.add(new ArrayList<>());

        bt(res, cur, nums, 0);

        return res;
    }

    private void bt(List<List<Integer>> res, List<Integer> cur, int nums[], int index) {

        if (index == nums.length) {
            return;
        }

        cur.add(nums[index]);
        res.add(new ArrayList<>(cur));
        bt(res, cur, nums, index + 1);

        cur.remove(cur.size() - 1);
        bt(res, cur, nums, index + 1);
    }
}