class Solution {
    public int[] plusOne(int[] digits) {
       int n = digits.length;
       if(n < 1) return digits;
     
       for(int i = n-1;i>=0;i--){
        int digit = digits[i];
        if(digit== 9){
            digits[i]=0;
       }else{
            digits[i]++;
            return digits;
       }
       }
       // all digits are nine then 
       digits = new int[n+1];
       digits[0] = 1;// remaining all are by default 0 on java
       return digits;

    }
}