
class Solution {
    public boolean dupSub(Node root) {
        
        HashMap<String, Integer> mp = new HashMap<>();
        
        solve(root, mp);
        
        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            
            if(entry.getValue() > 1) return true;
        }
        
        return false;
    }
    
    public String solve(Node root, HashMap<String, Integer> mp){
        
        if(root == null) return "N";
        
        if(root.left == null && root.right == null){
            
            return new String(root.data+"");
        }
        
        String left =  solve(root.left, mp);
        String right = solve(root.right, mp);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(left).append("#").append(right).append("#").append(root.data);
        
        String res = sb.toString();
        
        mp.put(res, mp.getOrDefault(res, 0)+1);
        
        return res;
        
    }
};
