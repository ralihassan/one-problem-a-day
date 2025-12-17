class NumberofSmoothDescentPeriodsofaStock {
    public long getDescentPeriods(int[] prices) {
        int prev = 1;
        long total = 1;

        for (int i=1; i<prices.length; i++) {
            if (prices[i] == prices[i-1]-1) {
                prev++;
            } else {
                prev = 1;
            }

            total += prev;
        }

        return total;
    }
}