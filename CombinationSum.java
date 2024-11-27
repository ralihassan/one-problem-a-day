import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum main = new CombinationSum();
        main.testCombinationSum();
    }

    public void testCombinationSum() {
        // Test case 1: No candidates
        int[] candidates1 = {};
        int target1 = 7;
        List<List<Integer>> expected1 = Arrays.asList();
        System.out.println(
                "Test case 1: " + (combinationSum(candidates1, target1).equals(expected1) ? "Passed" : "Failed"));

        // Test case 2: Single candidate equals target
        int[] candidates2 = { 7 };
        int target2 = 7;
        List<List<Integer>> expected2 = Arrays.asList(Arrays.asList(7));
        System.out.println(
                "Test case 2: " + (combinationSum(candidates2, target2).equals(expected2) ? "Passed" : "Failed"));

        // Test case 3: Multiple candidates, multiple combinations
        int[] candidates3 = { 2, 3, 6, 7 };
        int target3 = 7;
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7));
        System.out.println(
                "Test case 3: " + (combinationSum(candidates3, target3).equals(expected3) ? "Passed" : "Failed"));

        // Test case 4: Candidates with no valid combination
        int[] candidates4 = { 2, 4 };
        int target4 = 5;
        List<List<Integer>> expected4 = Arrays.asList();
        System.out.println(
                "Test case 4: " + (combinationSum(candidates4, target4).equals(expected4) ? "Passed" : "Failed"));

        // Test case 5: Candidates with duplicates
        int[] candidates5 = { 2, 3, 2 };
        int target5 = 5;
        List<List<Integer>> expected5 = Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(3, 2));
        System.out.println(
                "Test case 5: " + (combinationSum(candidates5, target5).equals(expected5) ? "Passed" : "Failed"));

        System.out.println("All test cases for combinationSum completed!");
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(candidates, res, cur, 0, target, 0);

        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> cur, int sum, int target, int index) {

        if (target < sum) {
            return;
        }

        if (target == sum) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(candidates, res, cur, sum + candidates[i], target, i);
            cur.remove(cur.size() - 1);
        }

    }

}