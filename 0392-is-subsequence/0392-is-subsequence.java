class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() ==0) return true;
        int sP = 0;
        int tP = 0;
        while(tP <t.length()){
            if(s.charAt(sP) == t.charAt(tP)){
                sP++;
            }
            if(sP == s.length()) return true;
            tP++;
        }
        return false;

    }
}