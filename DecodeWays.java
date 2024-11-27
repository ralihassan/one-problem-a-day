import java.util.*;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays main = new DecodeWays();
        main.testNumDecodings();
    }

    public void testNumDecodings() {
        // Test case 1: Single digit, valid decoding
        String s1 = "2";
        System.out.println("Test case 1: " + (numDecodings(s1) == 1 ? "Passed" : "Failed"));

        // Test case 2: Two digits, valid decoding
        String s2 = "12";
        System.out.println("Test case 2: " + (numDecodings(s2) == 2 ? "Passed" : "Failed"));

        // Test case 3: Leading zero, invalid decoding
        String s3 = "01";
        System.out.println("Test case 3: " + (numDecodings(s3) == 0 ? "Passed" : "Failed"));

        // Test case 4: Multiple digits, valid decoding
        String s4 = "226";
        System.out.println("Test case 4: " + (numDecodings(s4) == 3 ? "Passed" : "Failed"));

        // Test case 5: Multiple digits with zeros, valid decoding
        String s5 = "1203";
        System.out.println("Test case 5: " + (numDecodings(s5) == 1 ? "Passed" : "Failed"));

        // Test case 6: Single zero, invalid decoding
        String s6 = "0";
        System.out.println("Test case 6: " + (numDecodings(s6) == 0 ? "Passed" : "Failed"));

        // Test case 7: Multiple zeros, invalid decoding
        String s7 = "100";
        System.out.println("Test case 7: " + (numDecodings(s7) == 0 ? "Passed" : "Failed"));

        System.out.println("All test cases for numDecodings completed!");
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int dp[] = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (i > 1 && Integer.parseInt(s.substring(i - 2, i)) > 9 && Integer.parseInt(s.substring(i - 2, i)) < 27) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

}
