class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long absSum = 0;
        int negs = 0;

        for (int[] row : matrix) {
            for (int num : row) { 
                absSum += Math.abs(num);
                negs += num >= 0 ? 0 : 1;
                min = Math.min(min, Math.abs(num));
            }            
        }

        if (negs % 2 != 0) {
            absSum -= 2 * min;
        }

        return absSum;
    }
}