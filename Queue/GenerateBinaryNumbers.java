class Solution {
    public ArrayList<String> generateBinary(int n) {
        
        Queue<Pair> q = new LinkedList<>();
        
        ArrayList<String> res = new ArrayList<>();
        
        q.add(new Pair("1", 1));
        int cnt = 1;
        
        while(q.peek().second != n){
            
            res.add(q.peek().first);
            
            StringBuilder sb = new StringBuilder(q.peek().first);
            
            sb.append("0");
            
            q.add(new Pair(sb.toString(), ++cnt));
            
            sb.deleteCharAt(sb.length()-1);
            
            sb.append("1");
            
            q.add(new Pair(sb.toString(), ++cnt));
            
            q.remove();
            
        }
        
        res.add(q.peek().first);
        
        return res;
    }
    
}

class Pair{
    String first;
    int second;
    
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
