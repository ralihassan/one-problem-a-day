public class JumpGameTwo {

    public static void main(String[] args) {
        JumpGameTwo main = new JumpGameTwo();
        testJump();
    }

    public static void testJump() {

        // Test case 1: Minimum jumps needed
        int[] nums1 = { 2, 3, 1, 1, 4 };
        int expected1 = 2; // Jump from index 0 to 1, then to the end
        int result1 = jump(nums1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: Already at the end
        int[] nums2 = { 0 };
        int expected2 = 0; // No jumps needed
        int result2 = jump(nums2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Cannot reach the end
        int[] nums3 = { 3, 2, 1, 0, 4 };
        int expected3 = -1; // Cannot reach the end
        int result3 = jump(nums3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Large jump at the start
        int[] nums4 = { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int expected4 = 1; // One jump to the end
        int result4 = jump(nums4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Multiple jumps needed
        int[] nums5 = { 1, 2, 3, 4, 5 };
        int expected5 = 3; // Jump from index 0 to 1, to 3, then to the end
        int result5 = jump(nums5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    public static int jump(int[] nums) {

        int jumps = 0;
        int cur = nums[0];
        int next = nums[0];

        for (int i = 1; i < nums.length; i++) {
            next = Math.max(next, nums[i]);

            if (cur >= nums.length - 1) {
                return jumps;
            }

            if (cur == i) {
                cur = next;
                jumps++;
            }
        }

        return -1;
    }

}
