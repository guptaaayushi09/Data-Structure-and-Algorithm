class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;

        for(int w : weights){
            maxWeight = Math.max(maxWeight, w);
            totalWeight +=w;   
        }
        int low = maxWeight;
        int high = totalWeight;
        int ans = high;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(canShip(weights,days,mid)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid +1;
            }
        }

    return ans;
        
    }
    private boolean canShip(int[] weights,  int days, int capacity){
        int cDays = 1;
        int cLoad = 0;

        for(int w : weights){
            if(cLoad + w <= capacity){
                    cLoad +=w;
            }else{
                cDays++;
                cLoad = w;

            }
        }
        return cDays<=days;
    }
}