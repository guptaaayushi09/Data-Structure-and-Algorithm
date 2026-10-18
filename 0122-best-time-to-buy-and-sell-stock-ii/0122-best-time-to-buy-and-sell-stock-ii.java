class Solution {
    public int maxProfit(int[] prices) {
        // can carry only 1 share 

        int maxP = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]> prices[i-1]){
                maxP+=(prices[i]-prices[i-1]); // unlimited time txn 
            }
        }
        return maxP;
    }
}