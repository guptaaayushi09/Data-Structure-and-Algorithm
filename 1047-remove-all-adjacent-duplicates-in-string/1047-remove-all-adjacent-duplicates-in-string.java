class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int length = 0;
        for(int i =0;i<n;i++){
            char current = s.charAt(i);
            if(length >0 && sb.charAt(length-1) == current){
             sb.deleteCharAt(length-1);
             length--;
            }else{
                sb.append(current);
                length++;
            }
        }
        return sb.toString();
    }
}