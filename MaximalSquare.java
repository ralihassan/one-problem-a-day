public class MaximalSquare {

    public static void main(String[] args) {
        testMaximalSquare();
    }

    private static void testMaximalSquare() {
        MaximalSquare main = new MaximalSquare();

        // Test case 1: Simple square
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int expected1 = 4; // 2x2 square
        int result1 = main.maximalSquare(matrix1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: No square
        char[][] matrix2 = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        int expected2 = 0; // No square
        int result2 = main.maximalSquare(matrix2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Single element matrix
        char[][] matrix3 = {
            {'1'}
        };
        int expected3 = 1; // Single element square
        int result3 = main.maximalSquare(matrix3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Single row matrix
        char[][] matrix4 = {
            {'1', '1', '1', '1'}
        };
        int expected4 = 1; // Only 1x1 squares possible
        int result4 = main.maximalSquare(matrix4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Single column matrix
        char[][] matrix5 = {
            {'1'},
            {'1'},
            {'1'},
            {'1'}
        };
        int expected5 = 1; // Only 1x1 squares possible
        int result5 = main.maximalSquare(matrix5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));

        // Test case 6: Large square
        char[][] matrix6 = {
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'}
        };
        int expected6 = 16; // 4x4 square
        int result6 = main.maximalSquare(matrix6);
        System.out.println("Test case 6: " + (result6 == expected6 ? "Passed" : "Failed"));
    }

    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int max = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == '1') {
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }
}