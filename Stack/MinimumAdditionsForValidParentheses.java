class Solution {
    public int minParentheses(String s) {
        
        Stack<Character> st = new Stack<>();
        int left = 0;
        
        for(char ch : s.toCharArray()){
            
            if(ch == '(') st.push(ch);
            else{
                if(st.isEmpty()) left++;
                else st.pop();
            }
        }
        
        int total = left + st.size();
        
        return total;
        
    }
}
