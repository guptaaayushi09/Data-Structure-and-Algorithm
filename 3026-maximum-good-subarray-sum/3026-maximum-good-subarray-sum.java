class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        Map<Long,Long> mp = new HashMap<>();
        long ans = Long.MIN_VALUE;
       
       for(int i =0;i<n;i++){
        int num = nums[i];
        sum+=num;
        long key = num +k;
        if(mp.containsKey(key)){
            ans = Math.max(ans,sum-mp.get(key));
        }
        key = num-k;
        if(mp.containsKey(key)) {ans = Math.max(ans,sum-mp.get(key));}

        key = num;
        if(!mp.containsKey(key)) mp.put(key,sum-num);
        else {
            long f = mp.get(key);
            if(sum-num < f) mp.put(key, sum-num);

        }
       }

    return ans == Long.MIN_VALUE? 0: ans;
    }
}