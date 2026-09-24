class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1 || numRows >= s.length()){
            return s;
        }
        int index = 0, direction = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for(int i = 0;i<numRows;i++){
            rows[i] = new ArrayList<>();
        }
        //01232101232101 -> numbering is row number , have to build row then concatenate each row will be horizontal reading
        for(char c: s.toCharArray()){
            rows[index].add(c);
            if(index == 0) direction = 1; // for doing plus one in index or for moving forwrd
            else if(index == numRows -1) direction = -1; // for moving backwards

            index+=direction;
        }
        StringBuilder ans = new StringBuilder();
        for(List<Character> row : rows){
            for(char c:row){
                ans.append(c);
            }
        }

        return ans.toString();
    }
}