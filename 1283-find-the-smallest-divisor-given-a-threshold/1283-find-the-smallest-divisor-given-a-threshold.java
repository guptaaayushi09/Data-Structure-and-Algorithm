class Solution {
    private static int reminderSum(int[] nums, int divisor){
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] %divisor ==0) sum+=(nums[i] /divisor);
            else sum+=(nums[i] /divisor +1);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = 0;
         int low = 1,high = 0;
        for(int i: nums) {
            if( i> high) high = i;// here max search for binary number is max number, let's say max is sum of all number but if we do division by max number in array to all the numbers it will be 1 for all the elements as divisionis ceil here condition givenin question so 1+1 + length of array only and if we increase number answer will be same again len of array so upper boundis max element in array as threshold is givn will always be grrater or = to array lenght
        }
        int ans = 1;
       
        while(low<=high){
            int mid = low + (high-low)/2;
            int sum = reminderSum(nums,mid);
            if(sum <= threshold) {
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}