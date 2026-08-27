class Solution {
    public static String infixToPostfix(String s) {
       
       Stack<Character> optr = new Stack<>();
       Stack<String> val = new Stack<>();
       
        for(char ch : s.toCharArray()){
            
            if(Character.isLetterOrDigit(ch)) 
                val.push(String.valueOf(ch));
            
            else if(ch == '(' || optr.isEmpty() 
            || (optr.peek() == '(' && ch != ')')){
                optr.push(ch);
            }
            else if(ch == '^' && optr.peek() == '^'){
                optr.push(ch);
            }
            else{
                if(ch == ')'){
                    
                    while(optr.peek() != '('){
                        
                    String s1 = val.pop();
                    String s2 = val.pop();
                    
                    String res = evaluate(s1, s2, optr.pop());
                    val.push(res);
                    
                    }
                    
                    optr.pop();
                    
                }else{
                    
                    while(!optr.isEmpty() && 
                    precedence(ch) <= precedence(optr.peek())
                    && optr.peek() != '('
                    ){
                        
                    String s1 = val.pop();
                    String s2 = val.pop();
                    
                    String res = evaluate(s1, s2, optr.pop());
                    val.push(res);
                    
                    }
                    
                    optr.push(ch);
                }
            }
        }
        
        while(!optr.isEmpty()){

        String s1 = val.pop();
        String s2 = val.pop();

        String res = evaluate(s1, s2, optr.pop());
        val.push(res);

        }
        
        return val.peek();
        
    }
    
    public static int precedence(char ch){
        if(ch == '+' || ch == '-') return 0;
        if(ch == '*' || ch == '/' ) return 1;
        
        return 2;
    }
    
    public static String evaluate(String s1, String s2, char ch){
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(s2).append(s1).append(ch);
        
        return sb.toString();
    }
}
