

class Solution {
    public ArrayList<Integer> topView(Node root) {
       
       TreeMap<Integer, int[]> tm = new TreeMap<>();
       
       solve(tm, 0, 0, root);
       
       ArrayList<Integer> res = new ArrayList<>();
      
       for(Map.Entry<Integer, int[]> entry : tm.entrySet()){
           
           res.add(entry.getValue()[0]);
       }
       
       return res;
        
    }
    public void solve(TreeMap<Integer, int[]> tm, int hd, int lvl, Node root){
        
        
        if(root == null) return;
        
        if(!tm.containsKey(hd) || 
        (tm.containsKey(hd) && lvl < tm.get(hd)[1])){
            
            tm.put(hd, new int[]{root.data, lvl});
        }
        
        solve(tm, hd-1, lvl+1, root.left);
        solve(tm, hd+1, lvl+1, root.right);
    }
}
