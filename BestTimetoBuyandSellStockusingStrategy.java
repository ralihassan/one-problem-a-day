class BestTimetoBuyandSellStockusingStrategy {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long profitSum[] = new long[n+1];
        long priceSum[] = new long[n+1];

        for (int i=0; i<n; i++) {
            profitSum[i+1] = profitSum[i] + ((long) prices[i] * strategy[i]);
            priceSum[i+1] = priceSum[i] + prices[i];
        }

        long profit = profitSum[n];
        for (int i=k-1; i<n; i++) {
            long leftProfitSum = profitSum[i-k+1];
            long rightProfitSum = profitSum[n] - profitSum[i+1];
            long changeProfit = priceSum[i+1] - priceSum[i-k/2+1];
            profit = Math.max(profit, leftProfitSum+rightProfitSum+changeProfit);
        }

        return profit;
    }
}