class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;

        long product = 1;
        for(int i :nums) product*=i;

        if(product != target*target) return false;

        for(int i =1 ;i <(1<<n)-1;i++){
            long currentProd = 1;

            for(int j = 0;j<n;j++){
                if(((i>>j) & 1 )==1) currentProd *=nums[j];
                if(currentProd >target) break;
            }
            if(currentProd == target) return true;

            if(currentProd == target) return true;
        }
        return false;
    }
}