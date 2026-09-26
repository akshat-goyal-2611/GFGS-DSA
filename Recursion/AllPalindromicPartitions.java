class Solution {
    public static ArrayList<ArrayList<String>> palinParts(String s) {
        
         ArrayList<ArrayList<String>> res = new ArrayList<>();
         
         StringBuilder sb = new StringBuilder();
         ArrayList<String> curr = new ArrayList<>();
        
         
         solve(sb, res, 0, curr, false, s, s.length());
        return res;
    }
    
    public static void solve(StringBuilder sb, 
    ArrayList<ArrayList<String>> res, int i, 
    ArrayList<String> curr, boolean flag, String s, int n){
        
        if(i == n) {
            
            if(flag){
                
            ArrayList<String> hel = new ArrayList<>(curr);
            
            res.add(hel);
                
            }
           
            return;
        }
        
        sb.append(s.charAt(i));
        
        if(palindrome(sb)){
            
            curr.add(sb.toString());
            
            solve(new StringBuilder(), res, i+1, curr, true, s, n);
            
            curr.remove(curr.size()-1);
            
            if(i != n-1) solve(sb, res, i+1, curr, true, s, n);
            
        }else{
            
            solve(sb, res, i+1, curr, false, s, n);
 
        }
        
        sb.deleteCharAt(sb.length()-1);
    }
    
    public static boolean palindrome(StringBuilder sb){
        
        int i = 0, j = sb.length()-1;
        
        while(i < j){
            
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++; j--;
        }
        
        return true;
    }
}
