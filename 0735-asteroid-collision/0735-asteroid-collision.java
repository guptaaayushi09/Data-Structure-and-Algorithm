class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack = new Stack<>();

        for(int i: asteroids){
            boolean destroyed = false;
            while(!stack.isEmpty() && (stack.peek() >0 && i <0)){ // basically we just hve to check the directions and specially positive moving direction
                if(Math.abs(stack.peek())  == Math.abs(i)){
                        destroyed = true;
                        stack.pop();
                        break;
                        
                } else if(Math.abs(i) < Math.abs(stack.peek())){
                             destroyed = true;
                             break;
                        }
                         else {
                            stack.pop();
                         } 
            }
            if(!destroyed)
            stack.push(i);
        }
        int[] result = new int[stack.size()];
       int n = stack.size();
       for(int i = n-1;i>=0;i--){
        result[i] = stack.pop();
       }
        return result;
    }
}