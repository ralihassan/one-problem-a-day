import java.util.Arrays;

public class OnesandZeroes {

    public static void main(String[] args) {
        testFindMaxForm();
    }

    public static void testFindMaxForm() {
        OnesandZeroes main = new OnesandZeroes();

        // Test case 1: Basic test case
        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        int m1 = 5;
        int n1 = 3;
        int expected1 = 4;
        int result1 = main.findMaxForm(strs1, m1, n1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: Minimal input
        String[] strs2 = {"10", "0", "1"};
        int m2 = 1;
        int n2 = 1;
        int expected2 = 2;
        int result2 = main.findMaxForm(strs2, m2, n2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Edge case with no strings
        String[] strs3 = {};
        int m3 = 1;
        int n3 = 1;
        int expected3 = 0;
        int result3 = main.findMaxForm(strs3, m3, n3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Edge case with maximum constraints
        String[] strs4 = new String[600];
        Arrays.fill(strs4, "0");
        int m4 = 600;
        int n4 = 0;
        int expected4 = 600;
        int result4 = main.findMaxForm(strs4, m4, n4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: All strings exceed m and n
        String[] strs5 = {"111", "000"};
        int m5 = 1;
        int n5 = 1;
        int expected5 = 0;
        int result5 = main.findMaxForm(strs5, m5, n5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for (String str : strs) {
            int zero = 0;
            int one = 0;

            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }

            for (int i=m; i>=zero; i--) {
                for (int j=n; j>=one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-one] + 1);
                }
            }
        }

        return dp[m][n];
    }

}