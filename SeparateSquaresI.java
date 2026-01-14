class SeparateSquaresI {
    public double separateSquares(int[][] squares) {
        double topY = 0.0;
        double totalArea = 0.0;

        for (int[] square : squares) {
            topY = Math.max(topY, (double) square[1] + square[2]);
            totalArea += (double) square[2] * square[2];
        }

        double halfArea = totalArea/2.0;

        double left = 0.0, right = topY;

        while (Math.abs(right - left) > 1e-5) {
            double mid = (right + left)/2.0;
            double area = computeArea(squares, mid);
            if (area < halfArea){
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private double computeArea(int[][] squares, double topY) {
        double area = 0.0;

        for (int[] square : squares) {
            if (square[1] < topY) {
                area += (double) square[2] * Math.min(topY - square[1], (double) square[2]);
            }
        }

        return area;
    }
}