/*class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0,i;
        int buy=prices[0];
        for(i=1;i<n;i++){
            if(prices[i]>buy){
                profit+=prices[i]-buy;
            }
            buy=prices[i];
        }
        return profit;
    }
}*/

class Solution {

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 1, prices, dp);
    }

    private int solve(int i, int buy, int[] prices, int[][] dp) {

        if (i == prices.length)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        if (buy == 1) {

            return dp[i][buy] = Math.max(
                    -prices[i] + solve(i + 1, 0, prices, dp),
                    solve(i + 1, 1, prices, dp)
            );

        } else {

            return dp[i][buy] = Math.max(
                    prices[i] + solve(i + 1, 1, prices, dp),
                    solve(i + 1, 0, prices, dp)
            );
        }
    }
}