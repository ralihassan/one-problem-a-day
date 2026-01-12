class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int[] last = points[0];

        for (int i=1; i<points.length; i++) {
            int x = Math.abs(last[0] - points[i][0]);
            int y = Math.abs(last[1] - points[i][1]);
            int min = Math.min(x,y);
            ans += min;
            ans += Math.max(x,y) - min;
            last = points[i];
        }

        return ans;
    }
}