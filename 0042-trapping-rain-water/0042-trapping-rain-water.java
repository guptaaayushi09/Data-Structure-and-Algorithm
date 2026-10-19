class Solution {
    public int trap(int[] height) {
        // water[i] = Max(0, min(left_max,right_max) - heights[i])
        
        // if heihgt left < curr then there must be 
        int n = height.length;
        int left_max= 0;
        int right_max = 0;
        int ans = 0;
        int left = 0, right = n-1;
        while(left <= right){
            if(height[left]<=height[right]){
              left_max = Math.max(left_max,height[left]);
              ans+=(left_max-height[left]);
              left++;
            }else{
                right_max = Math.max(right_max,height[right]);
                ans+=(right_max-height[right]);
                right--;
            }
        }
        return ans;
    }
}