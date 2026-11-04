class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length ==0 || k ==0 ) return 0;

        int n = prices.length;
       

        if(k >=n/2){ // for n prices size we can do n/2 unlimited transaction as 1 transaction means  1 buy and 1 sell and we cant do on the same day.
         int maxP = 0;
          for(int i =1;i<n;i++){
            if(prices[i]> prices[i-1]) maxP+= (prices[i]-prices[i-1]);
          }
          return maxP;
        }
        // whole trick is reinvest the profit to calculate the final profit
        int[] minCost = new int[k+1]; // min price till at point i
        int[] profit = new int[k+1];// max profit till at point i

        for(int j = 1;j<=k;j++) minCost[j] = prices[0];

        for(int i =1;i<n;i++){
            for(int j = 1;j<=k;j++){
                minCost[j] = Math.min(minCost[j],prices[i]-profit[j-1]);                // Effective cost = current price minus profit from the PREVIOUS transaction (j-1)
                profit[j] = Math.max(profit[j],prices[i]- minCost[j]);

            }

        }
        return profit[k];
    }
}