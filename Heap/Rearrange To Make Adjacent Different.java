class Solution {
    public boolean canRearrange(String s) {
        
        HashMap<Character, Integer> mp = new HashMap<>();
        
        int n = s.length();
        
        for(int i = 0; i < n ; i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        // string, integer
        PriorityQueue<Pair> pq = new
        PriorityQueue<>((a,b)->Integer.compare(b.freq, a.freq));
        
        for(Map.Entry<Character, Integer> entry : mp.entrySet()){
            
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        StringBuilder pL = new StringBuilder("#");
        
        while(!pq.isEmpty()){
            
            char curr = pq.peek().ch;
            char prev = pL.charAt(pL.length()-1);
            
            if(curr == prev){
                
                // delete curr letter 
                Pair delE = pq.poll();
                
                if(pq.isEmpty()) return false;
                
                char topLetter = pq.peek().ch;
                
                pL.append(topLetter);
                
                if(pq.peek().freq == 1) pq.poll();
                else{
                    
                    int f = pq.peek().freq;
                    pq.poll();
                    
                    pq.add(new Pair(topLetter, f-1));
                }
                
                pq.add(delE);
                
                
            }else{
                
                pL.append(curr);
                
                if(pq.peek().freq == 1) pq.poll();
                else{
                    
                   int f = pq.peek().freq;
                    pq.poll();
                    
                    pq.add(new Pair(curr, f-1));
                   
                }
            }
        }
        
        return true;
        
    }
}

class Pair{
    
    char ch;
    int freq;
    
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
    
}
