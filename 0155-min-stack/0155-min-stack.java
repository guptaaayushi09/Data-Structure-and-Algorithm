class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);// 5 7
        if(minStack.isEmpty()){
            minStack.push(value);
        }else{
            minStack.push(Math.min(value,minStack.peek())); // either pushing minimum or same value to be in sync with main Stack so that pop will not affect. 5 5 so
        }
    }
    
    public void pop() {
        minStack.pop(); // will remove the redundant value that pushed when the value is not less
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       int minValue = minStack.peek();// just getting value not removing 
       return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */