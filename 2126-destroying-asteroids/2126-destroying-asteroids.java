class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long M = mass;
        for(int i : asteroids){
            if( M >=i) M+= i;
            else return false;

        }
        return true;
    }
}