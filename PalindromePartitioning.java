import java.util.*;

public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning main = new PalindromePartitioning();
        main.testPartition();
    }

    public static void testPartition() {
        PalindromePartitioning main = new PalindromePartitioning();

        // Test case 1: Single character string
        String s1 = "a";
        List<List<String>> expected1 = Arrays.asList(Arrays.asList("a"));
        List<List<String>> result1 = main.partition(s1);
        System.out.println("Test case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        // Test case 2: Two character palindrome
        String s2 = "aa";
        List<List<String>> expected2 = Arrays.asList(Arrays.asList("a", "a"), Arrays.asList("aa"));
        List<List<String>> result2 = main.partition(s2);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // Test case 3: Non-palindrome string
        String s3 = "abc";
        List<List<String>> expected3 = Arrays.asList(Arrays.asList("a", "b", "c"));
        List<List<String>> result3 = main.partition(s3);
        System.out.println("Test case 3: " + (result3.equals(expected3) ? "Passed" : "Failed"));

        // Test case 4: Palindrome with mixed characters
        String s4 = "aab";
        List<List<String>> expected4 = Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"));
        List<List<String>> result4 = main.partition(s4);
        System.out.println("Test case 4: " + (result4.equals(expected4) ? "Passed" : "Failed"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        bk(res, cur, s, 0);

        return res;
    }

    private void bk(List<List<String>> res, List<String> cur, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int length = 0;
        while (index + length < s.length() && isPalindrome(s, index, index + length)) {
            cur.add(s.substring(index, index + length + 1));
            bk(res, cur, s, index + length + 1);
            length++;
            cur.remove(cur.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }

        return left >= right ? true : false;
    }

}