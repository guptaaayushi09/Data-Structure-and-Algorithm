class Solution {
    public int[] searchRange(int[] nums, int target) {
       int first = firstOccurence(nums,target);
       int last = firstOccurence(nums,target+1);

       return (first == last) ? new int[]{-1,-1}:new int[]{first,last-1};

    }

    private static int firstOccurence(int[] nums,int target){
      int lo = 0, hi = nums.length;
      while(lo<hi){ 
        int mid = lo + (hi-lo)/2;
        if(nums[mid] <  target) lo = mid+1;
        else hi = mid;
      }
    
      return lo;
       
    }
  
}