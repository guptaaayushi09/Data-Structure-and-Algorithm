class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0],buy2 = prices[0];
        int profit1 = 0, profit2 = 0;
        for(int i =1;i<prices.length;i++){
            buy1 = Math.min(buy1,prices[i]);
            profit1 = Math.max(profit1, prices[i]-buy1);

            buy2 = Math.min(buy2,prices[i]-profit1);// the money I earned from last profit we can use it in buying also so to calculate final profit .
            profit2 = Math.max(profit2,prices[i]- buy2);

        }
        return profit2;
    }
}