
class Solution {
    public TreeNode str2tree(String s) {
        if( s== null || s.isEmpty()) return null;
        Deque<TreeNode> st = new ArrayDeque<>();
        int num = 0;
        int sign  = 1;
        boolean hasNum = false;

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='-'){
                sign = -1;
            }else if(Character.isDigit(c)){
               num = num *10 + (c-'0');
               hasNum = true;
            }
            else {
                if(hasNum) {                     // flush the finished number into a node
                    TreeNode node = new TreeNode(sign * num);
                    if (!st.isEmpty()) {
                        TreeNode p = st.peek();
                        if (p.left == null) p.left = node; 
                        else p.right = node;
                    }
                    st.push(node);
                    num = 0; sign = 1; 
                    hasNum = false;
                }
                if (c == ')') st.pop();           // subtree done
                // '(' needs nothing — the node just pushed IS the new parent
            }
        }
        if(hasNum) st.push(new TreeNode(sign*num));
        return st.peek();
    } 
}