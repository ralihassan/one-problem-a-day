public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit main = new MaxProfit();
        main.testMaxProfit();
    }

    public static void testMaxProfit() {
        MaxProfit main = new MaxProfit();

        // Test case 1: Increasing prices
        int[] prices1 = { 1, 2, 3, 4, 5 };
        int expected1 = 4; // Buy on day 1, sell on day 5
        int result1 = main.maxProfit(prices1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: Decreasing prices
        int[] prices2 = { 5, 4, 3, 2, 1 };
        int expected2 = 0; // No transactions, no profit
        int result2 = main.maxProfit(prices2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Prices with peaks and valleys
        int[] prices3 = { 7, 1, 5, 3, 6, 4 };
        int expected3 = 7; // Buy on day 2, sell on day 3; buy on day 4, sell on day 5
        int result3 = main.maxProfit(prices3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Prices with no change
        int[] prices4 = { 3, 3, 3, 3, 3 };
        int expected4 = 0; // No transactions, no profit
        int result4 = main.maxProfit(prices4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Single day prices
        int[] prices5 = { 10 };
        int expected5 = 0; // No transactions possible
        int result5 = main.maxProfit(prices5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            } else {
                buy = prices[i];
            }
        }

        return profit;
    }

}