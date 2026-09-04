class Solution {
    static String decodedString(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            
            if(ch != ']') sb.append(ch);
            
            else{
                
                StringBuilder sub = new StringBuilder();
                
                while(sb.charAt(sb.length()-1) != '['){
                    
                    sub.insert(0, sb.charAt(sb.length()-1));
                    sb.deleteCharAt(sb.length()-1);
                }
                
                sb.deleteCharAt(sb.length()-1);
                
                StringBuilder k = new StringBuilder();
                
                while(!sb.isEmpty() &&
                Character.isDigit(sb.charAt(sb.length()-1))){
                    
                    k.insert(0, sb.charAt(sb.length()-1));
                    sb.deleteCharAt(sb.length()-1);
                }
                
                int num = Integer.parseInt(k.toString());
                
                for(int i = 0; i < num; i++){
                    sb.append(sub);
                }
                
            }
        }
        
        return sb.toString();
        
    }
}
