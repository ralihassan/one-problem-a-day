public class JumpGame {

    public static void main(String[] args) {
        JumpGame main = new JumpGame();
        main.testCanJump();
    }

    public static void testCanJump() {
        JumpGame main = new JumpGame();

        // Test case 1: Can jump to the end
        int[] nums1 = { 2, 3, 1, 1, 4 };
        boolean expected1 = true; // Can jump to the end
        boolean result1 = main.canJump(nums1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: Cannot jump to the end
        int[] nums2 = { 3, 2, 1, 0, 4 };
        boolean expected2 = false; // Cannot jump to the end
        boolean result2 = main.canJump(nums2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Single element
        int[] nums3 = { 0 };
        boolean expected3 = true; // Already at the end
        boolean result3 = main.canJump(nums3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: All zeros except first
        int[] nums4 = { 1, 0, 0, 0 };
        boolean expected4 = false; // Cannot jump to the end
        boolean result4 = main.canJump(nums4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Large jump at the start
        int[] nums5 = { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        boolean expected5 = true; // Can jump to the end
        boolean result5 = main.canJump(nums5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    public boolean canJump(int[] nums) {

        int jump = 0;

        for (int i = 0; i < nums.length; i++) {
            jump = Math.max(nums[i], jump - 1);
            if (i + jump >= nums.length - 1) {
                return true;
            } else if (jump == 0) {
                break;
            }
        }

        return false;
    }

}