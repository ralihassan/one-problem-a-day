public class CoinChange {

    public static void main(String[] args) {
        testCoinChange();
    }

    public static void testCoinChange() {
        CoinChange main = new CoinChange();

        // Test case 1: Basic test case
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int expected1 = 3; // 11 = 5 + 5 + 1
        int result1 = main.coinChange(coins1, amount1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: No solution possible
        int[] coins2 = {2};
        int amount2 = 3;
        int expected2 = -1; // No combination can make 3
        int result2 = main.coinChange(coins2, amount2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test case 3: Exact match with one coin
        int[] coins3 = {1};
        int amount3 = 0;
        int expected3 = 0; // No coins needed to make 0
        int result3 = main.coinChange(coins3, amount3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test case 4: Large amount with multiple coins
        int[] coins4 = {1, 2, 5};
        int amount4 = 100;
        int expected4 = 20; // 100 = 5 * 20
        int result4 = main.coinChange(coins4, amount4);
        System.out.println("Test case 4: " + (result4 == expected4 ? "Passed" : "Failed"));

        // Test case 5: Single coin type
        int[] coins5 = {2};
        int amount5 = 4;
        int expected5 = 2; // 4 = 2 + 2
        int result5 = main.coinChange(coins5, amount5);
        System.out.println("Test case 5: " + (result5 == expected5 ? "Passed" : "Failed"));
    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;

        for (int i=1; i<=amount; i++) {
            dp[i] = amount+1;
        }

        for (int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

}
