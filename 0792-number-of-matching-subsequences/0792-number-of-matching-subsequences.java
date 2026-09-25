class Solution {
    class Node{
        String word;
        int index;
        Node(String word, int index){
            this.word= word;
            this.index = index;
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        List<Node>[] buckets = new ArrayList[26];
        for(int i =0;i<26;i++){
            buckets[i] = new ArrayList<>();
        }
        for(String word:words){
            buckets[word.charAt(0)-'a'].add(new Node(word,0));
        }
        int matching = 0;
        for(char c : s.toCharArray()){
            List<Node> currentBucket = buckets[c-'a'];
            buckets[c-'a']= new ArrayList<>();
            for(Node node: currentBucket){
                node.index++;
                if(node.index ==node.word.length()){
                    matching++;
                }else{
                    char nextChar = node.word.charAt(node.index);
                    buckets[nextChar-'a'].add(node);
                }
            }
        }
        return matching;
    }
}