class Solution {
    public static int getMaxArea(int arr[]) {
       
       int n = arr.length;
       
       Stack<Integer> st = new Stack<>();
       int maxArea = 0;
       
       for(int i = 0; i < n; i++){
           
           while(!st.isEmpty() && arr[st.peek()] > arr[i]){
               
              int top = arr[st.pop()];
               
               if(st.isEmpty()){
                   maxArea = Math.max(top*i, maxArea);
               }else{
                   maxArea = Math.max(top*(i-st.peek()-1), maxArea);
               }
           }
           
           st.push(i);
           
       }
       
       while(!st.isEmpty()){
           
        int top = arr[st.pop()];
           
           if(st.isEmpty()){
               maxArea = Math.max(top*(n), maxArea);
           }else{
               maxArea = Math.max(top*(n-st.peek()-1), maxArea);
           }
           
       }
       
       return maxArea;
        
    }
}
