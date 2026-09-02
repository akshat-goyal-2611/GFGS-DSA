class SpecialStack {
    
    int min = 0;
    Stack<Integer> st;
    
    public SpecialStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        
        if(st.isEmpty()){
            st.push(x);
            min = x;
            return;
        }
        
        if(x < min){
            st.push(2*x-min);
            min = x;
        }else{
            st.push(x);
        }
    }

    public void pop() {
        
        if(!st.isEmpty()){
            
        if(st.size() == 1) {
            st.pop();
            min = -1;
        }
        
        else if(min > st.peek()){
            min = 2*min - st.peek();
            st.pop();
        }else{
            st.pop();
        }
        
        }
        
    }

    public int peek() {
        
        if(!st.isEmpty()){
         
        if(min > st.peek()){
           return min;
        }else{
            return st.peek();
        }
        
        }
        
        return -1;
        
    }

    boolean isEmpty() {
        
        return st.isEmpty();
    }

    public int getMin() {
        
        return min;
    }
}
