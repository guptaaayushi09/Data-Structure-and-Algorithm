class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        //length of subarray with all elements frequency less than k 
        // iterate over array -> continuous 
        // while iterating track freq
        //dry run -> map freq-> 
        // frequency exceeding k then stop-> then iterate from left to the last index of current elemet and decrement freq -> basically move left to last index of curr element +1;

        Map<Integer,Integer> freq = new HashMap<>();
        int length = 0;
        int l = 0, r = 0;
        int n = nums.length;

        while(r<n){
            freq.put(nums[r],freq.getOrDefault(nums[r],0)+1);
            
            while(freq.get(nums[r] ) > k){
                    freq.put(nums[l],freq.getOrDefault(nums[l],0)-1);
                    l++;
            }
 
            length = Math.max(length,r-l+1);
            r++;
        }

        return length;
    }
}