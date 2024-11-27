import java.util.*;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring main = new MinimumWindowSubstring();
        main.testMinWindow();
    }

    public void testMinWindow() {
        // Test case 1: Simple case
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Test case 1: " + (minWindow(s1, t1).equals("BANC") ? "Passed" : "Failed"));

        // Test case 2: No possible window
        String s2 = "A";
        String t2 = "AA";
        System.out.println("Test case 2: " + (minWindow(s2, t2).equals("") ? "Passed" : "Failed"));

        // Test case 3: Exact match
        String s3 = "ABC";
        String t3 = "ABC";
        System.out.println("Test case 3: " + (minWindow(s3, t3).equals("ABC") ? "Passed" : "Failed"));

        // Test case 4: Substring at the start
        String s4 = "AAABBBCCC";
        String t4 = "ABC";
        System.out.println("Test case 4: " + (minWindow(s4, t4).equals("ABBBC") ? "Passed" : "Failed"));

        // Test case 5: Substring at the end
        String s5 = "BBBAAACCC";
        String t5 = "ABC";
        System.out.println("Test case 5: " + (minWindow(s5, t5).equals("BAAAC") ? "Passed" : "Failed"));

        // Test case 6: Single character match
        String s6 = "A";
        String t6 = "A";
        System.out.println("Test case 6: " + (minWindow(s6, t6).equals("A") ? "Passed" : "Failed"));

        // Test case 7: Empty string
        String s7 = "";
        String t7 = "A";
        System.out.println("Test case 7: " + (minWindow(s7, t7).equals("") ? "Passed" : "Failed"));

        System.out.println("All test cases for minWindow completed!");
    }

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int freqT[] = new int[126];
        int freqS[] = new int[126];

        for (char c : t.toCharArray()) {
            freqT[c]++;
        }

        int required = t.length();
        int left = 0;
        int resLength = Integer.MAX_VALUE;
        String res = "";

        for (int right = 0; right < s.length(); right++) {
            if (required > 0) {
                char curr = s.charAt(right);
                freqS[curr]++;
                if (freqS[curr] <= freqT[curr]) {
                    required--;
                }
            }

            if (required == 0) {

                while (freqS[s.charAt(left)] > freqT[s.charAt(left)]) {
                    freqS[s.charAt(left)]--;
                    left++;
                }

                if (resLength > right - left + 1) {
                    resLength = right - left + 1;
                    res = s.substring(left, left + resLength);
                }

                freqS[s.charAt(left)]--;
                left++;
                required++;
            }
        }

        return res;

    }

}