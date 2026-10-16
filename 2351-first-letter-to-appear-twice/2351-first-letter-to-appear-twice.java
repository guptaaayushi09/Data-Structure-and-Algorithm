class Solution {
    public char repeatedCharacter(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq,-1);
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(freq[c-'a'] != -1){
                return c;
            }
            freq[c-'a'] = i;
        }
        return ' ';
    }
}