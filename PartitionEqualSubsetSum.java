public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        testCanPartition();
    }

    public static void testCanPartition() {
        PartitionEqualSubsetSum main = new PartitionEqualSubsetSum();

        // Test case 1: Simple case with partition possible
        int[] nums1 = {1, 5, 11, 5};
        boolean result1 = main.canPartition(nums1);
        System.out.println("Test case 1: " + (result1 == true ? "Passed" : "Failed"));

        // Test case 2: Simple case with partition not possible
        int[] nums2 = {1, 2, 3, 5};
        boolean result2 = main.canPartition(nums2);
        System.out.println("Test case 2: " + (result2 == false ? "Passed" : "Failed"));

        // Test case 4: Edge case with single element
        int[] nums4 = {1};
        boolean result4 = main.canPartition(nums4);
        System.out.println("Test case 4: " + (result4 == false ? "Passed" : "Failed"));

        // Test case 5: Larger array with partition possible
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7};
        boolean result5 = main.canPartition(nums5);
        System.out.println("Test case 5: " + (result5 == true ? "Passed" : "Failed"));

        // Test case 6: Larger array with partition not possible
        int[] nums6 = {1, 2, 5, 10, 11};
        boolean result6 = main.canPartition(nums6);
        System.out.println("Test case 6: " + (result6 == false ? "Passed" : "Failed"));
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum %2 != 0 || nums.length == 0) {
            return false;
        }
        
        int target = sum/2;
        boolean dp[] = new boolean[target+1];
        dp[0] = true;

        for (int num : nums) {
            for (int i=0; i+num<=target; i++) {
                dp[i+num] = dp[i] || dp[i+num];
            }
        }

        return dp[target];
    }

}