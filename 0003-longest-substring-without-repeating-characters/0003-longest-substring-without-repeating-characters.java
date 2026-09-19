class Solution {
    public int lengthOfLongestSubstring(String s) {
        // track repeation
        // track length till it doesn't repeat

        Map<Integer,Integer> mp = new HashMap<>();
        int n = s.length();
        int l = 0, r= 0;
        int len = 0;
        while(r<n){
            if(mp.containsKey(s.charAt(r)-'a')){
                l = Math.max(mp.get(s.charAt(r)-'a')+1,l);
            }
            mp.put(s.charAt(r)-'a',r);
            len = Math.max(len,r-l+1);
            r++;
        }
        return len;
        
       }
}