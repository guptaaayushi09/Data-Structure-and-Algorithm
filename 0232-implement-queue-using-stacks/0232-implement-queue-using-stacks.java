class MyQueue {
    Stack<Integer> offerStack;
    Stack<Integer>pollStack;
    public MyQueue() {
        offerStack = new Stack<>();
        pollStack = new Stack<>();
    }
    
    public void push(int x) {
        while(!pollStack.isEmpty()){
            offerStack.push(pollStack.peek());
            pollStack.pop();
        }
        pollStack.push(x);
        while(!offerStack.isEmpty()){
            pollStack.push(offerStack.pop());
        }
    }
    
    public int pop(){
       return pollStack.pop();
    }
    
    public int peek() {
        return pollStack.peek();
    }
    
    public boolean empty() {
        return pollStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */