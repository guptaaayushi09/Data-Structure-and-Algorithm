class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(sb.length() > 0 && sb.charAt(sb.length()-1)==ch){
                countStack.push(countStack.peek()+1);
            }else{
                countStack.push(1);
            }
            sb.append(ch);
            if(countStack.peek() ==k){
                sb.setLength(sb.length() -k);
                for(int j = 0;j<k;j++){
                    countStack.pop();
                }
            }
        }
        return sb.toString();
    }
}