class Solution {
    public int longestSubsequence(int[] nums) {
        // 1. totalXOR non-zero then n is the answer
        //2. totalXOR zero -> 1. all zero element answer 0 (a^0= a)
                          //-> 2. there will be alteast one which is non-zero which is duplicate 
                          

        int n = nums.length;
        int totalXor = 0;
        boolean allZero = true;

        for(int x :nums){
            totalXor ^= x;
            if(x>0) allZero = false;

        }
        if(totalXor >0) return n;
        return allZero? 0: n-1;
    }
}