class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int rs = 0, re = m-1, cs = 0, ce = n-1;
        
        while( rs <= re && cs <= ce){
            
            // rs constant
            for(int j = cs; j <= ce; j++){
                res.add(arr[rs][j]);
            }
            
            rs++;
            
            if(rs > re || cs > ce) break;
            
            // ce constant
            for(int i = rs; i <= re; i++){
                res.add(arr[i][ce]);
            }
            ce--;
            
            if(rs > re || cs > ce) break;
            
            // re constant
            for(int j = ce; j >= cs; j--){
                res.add(arr[re][j]);
            }
            
            re--;
            
            if(rs > re || cs > ce) break;
            
            // cs constant
            for(int i = re; i >= rs; i--){
                res.add(arr[i][cs]);
            }
            
            cs++;
         }
        
        return res;
    }
}
