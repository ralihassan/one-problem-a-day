public class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        testLongestIncreasingPath();
    }

    private static void testLongestIncreasingPath() {
        LongestIncreasingPathInAMatrix main = new LongestIncreasingPathInAMatrix();

        // Test case 1: Simple increasing path
        int[][] matrix1 = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        int expected1 = 4; // Path: 1 -> 2 -> 6 -> 9
        int result1 = main.longestIncreasingPath(matrix1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: All elements are the same
        int[][] matrix2 = {
            {7, 7, 7},
            {7, 7, 7},
            {7, 7, 7}
        };
        int expected2 = 1; // No increasing path, only single elements
        int result2 = main.longestIncreasingPath(matrix2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Single row matrix
        int[][] matrix3 = {
            {1, 2, 3, 4, 5}
        };
        int expected3 = 5; // Path: 1 -> 2 -> 3 -> 4 -> 5
        int result3 = main.longestIncreasingPath(matrix3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Single column matrix
        int[][] matrix4 = {
            {5},
            {4},
            {3},
            {2},
            {1}
        };
        int expected4 = 5; // No increasing path, only single elements
        int result4 = main.longestIncreasingPath(matrix4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Complex matrix with multiple paths
        int[][] matrix5 = {
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        };
        int expected5 = 4; // Path: 3 -> 4 -> 5 -> 6
        int result5 = main.longestIncreasingPath(matrix5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    public int longestIncreasingPath(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int memo[][] = new int[rows][cols];

        int maxlength = 0;

        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                maxlength = Math.max(maxlength, dfs(matrix, memo, row, col));
            }
        }

        return maxlength;
    }

    private int dfs(int matrix[][], int memo[][], int row, int col) {
        if (memo[row][col] > 0) {
            return memo[row][col];
        }
        
        int length = 1;
        int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0} };

        for (int i=0; i<dir.length; i++) {
            if (row + dir[i][0] >=0 &&  row + dir[i][0] < matrix.length && 
                col + dir[i][1] >=0 && col + dir[i][1] < matrix[0].length && 
                matrix[row][col] < matrix[row + dir[i][0]][col + dir[i][1]]) {
                length = Math.max(length, dfs(matrix, memo, row + dir[i][0], col + dir[i][1])+1);
            }            
        }

        memo[row][col] = length;

        return length;
    }

}