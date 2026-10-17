class Solution {
    public char nonRepeatingChar(String s) {
      
       int n = s.length();

       HashMap<Character, Integer> ms = new HashMap<>();
       
       for(int i = 0; i < n; i++){
           
           ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i), 0)+1);
       }
       
       for(char ch : s.toCharArray()){
           
                
                int cnt = ms.get(ch);
                
                if(cnt == 1) return ch;
       }
       
       return '$';
        
    }
}
