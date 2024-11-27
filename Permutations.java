import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        Permutations main = new Permutations();
        main.testPermute();
    }

    public void testPermute() {
        // Test case 2: Single element
        int[] nums2 = { 1 };
        List<List<Integer>> expected2 = Arrays.asList(Arrays.asList(1));
        System.out.println(
                "Test case 2: " + (permute(nums2).equals(expected2) ? "Passed" : "Failed"));

        // Test case 3: Two elements
        int[] nums3 = { 1, 2 };
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 1));
        System.out.println(
                "Test case 3: " + (permute(nums3).equals(expected3) ? "Passed" : "Failed"));

        // Test case 4: Three elements
        int[] nums4 = { 1, 2, 3 };
        List<List<Integer>> expected4 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1));
        System.out.println(
                "Test case 4: " + (permute(nums4).equals(expected4) ? "Passed" : "Failed"));

        System.out.println("All test cases for permute completed!");
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        dfs(nums, res, cur, set);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, Set<Integer> set) {

        int n = nums.length;
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                cur.add(nums[i]);
                set.add(nums[i]);
                dfs(nums, res, cur, set);
                cur.remove(cur.size() - 1);
                set.remove(nums[i]);
            }

        }
    }

}