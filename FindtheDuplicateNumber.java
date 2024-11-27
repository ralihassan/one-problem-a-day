import java.util.*;

public class FindtheDuplicateNumber {

    public static void main(String[] args) {
        FindtheDuplicateNumber main = new FindtheDuplicateNumber();
        main.testFindDuplicate();
    }

    public void testFindDuplicate() {
        // Test case 1: Single duplicate
        int[] nums1 = { 1, 3, 4, 2, 2 };
        System.out.println("Test case 1: " + (findDuplicate(nums1) == 2 ? "Passed" : "Failed"));

        // Test case 2: Single duplicate
        int[] nums2 = { 3, 1, 3, 4, 2 };
        System.out.println("Test case 2: " + (findDuplicate(nums2) == 3 ? "Passed" : "Failed"));

        // Test case 3: Single duplicate
        int[] nums3 = { 1, 1 };
        System.out.println("Test case 3: " + (findDuplicate(nums3) == 1 ? "Passed" : "Failed"));

        // Test case 4: Single duplicate
        int[] nums4 = { 1, 1, 2 };
        System.out.println("Test case 4: " + (findDuplicate(nums4) == 1 ? "Passed" : "Failed"));

        // Test case 5: Larger array with a single duplicate
        int[] nums5 = { 9, 7, 8, 5, 4, 6, 2, 3, 1, 5 };
        System.out.println("Test case 5: " + (findDuplicate(nums5) == 5 ? "Passed" : "Failed"));

        System.out.println("All test cases completed!");
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

}