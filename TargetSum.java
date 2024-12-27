public class TargetSum {

    public static void main(String[] args) {
        testFindTargetSumWays();
    }

    private static void testFindTargetSumWays() {
        TargetSum main = new TargetSum();

        // Test case 1: Simple case
        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int expected1 = 5;
        int result1 = main.findTargetSumWays(nums1, target1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: No possible ways
        int[] nums2 = {1, 2, 3};
        int target2 = 7;
        int expected2 = 0;
        int result2 = main.findTargetSumWays(nums2, target2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: All elements are zero
        int[] nums3 = {0, 0, 0, 0};
        int target3 = 0;
        int expected3 = 16; // 2^4 ways
        int result3 = main.findTargetSumWays(nums3, target3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Single element equal to target
        int[] nums4 = {5};
        int target4 = 5;
        int expected4 = 1;
        int result4 = main.findTargetSumWays(nums4, target4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Large numbers with no solution
        int[] nums5 = {100, 200, 300};
        int target5 = 1000;
        int expected5 = 0;
        int result5 = main.findTargetSumWays(nums5, target5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum || (sum + target)%2 != 0) {
            return 0;
        }

        int pos = (sum + target)/2;

        int dp[] = new int[pos + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = pos; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[pos];
    }
}
