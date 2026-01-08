class MaxDotProductofTwoSubsequences {
    int[] nums1;
    int[] nums2;
    int m, n;
    int[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.m = nums1.length; 
        this.n = nums2.length;
        this.dp = new int[m][n];

        for (int arr[]: dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }

        return dp(0,0);
    }

    private int dp(int i, int j) {
        if (i == m || j == n) return (int) -1e9;

        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int take = nums1[i] * nums2[j];

        // 4 options a each step:
        // a) take + stop
        // a) take + continue
        // a) skip nums1
        // a) skip nums2
        int res = Math.max(Math.max(take, take + dp(i+1,j+1)), Math.max(dp(i+1,j), dp(i,j+1)));
        dp[i][j] = res;

        return dp[i][j];
    }
}