class Solution {
    public int minDeletions(String s) {
        // two different hve same freq
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        int minD = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int f : freq){
            while(f > 0 && set.contains(f)){
                f--;
                minD++;
            }
            if(f > 0 ) set.add(f);
        }
        return minD;
    }
}