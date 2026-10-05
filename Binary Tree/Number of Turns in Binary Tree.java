
class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        
        return solve(root, p, q);
        
    }
    
    public int solve(Node root, int p, int q){
        
        ArrayList<Node> pathP = new ArrayList<>();
        ArrayList<Node> pathQ = new ArrayList<>();
        
        rootToTar(pathP, root, p);
        rootToTar(pathQ, root, q);
        
        int i = 0, j = 0, k = -1;
        
        ArrayList<Node> path = new ArrayList<>();
        
        while(i < pathP.size() && j < pathQ.size()
        && pathP.get(i).data == pathQ.get(j).data){
           
            i++; j++; k++;
        }
        
        i = 0;
        for(i = pathP.size()-1; i >= k; i--){
            path.add(pathP.get(i));
        }
        
        j = k+1;
        for( j = k+1; j < pathQ.size(); j++){
            
            path.add(pathQ.get(j));
        }
        
        int preDir = 0;
        
        i = 0;
        int turns = 0;
        
        for(i = 0; i < path.size()-1; i++){
            
            int currDir = 0;
            
            if(path.get(i).right == path.get(i+1)){
                currDir = 2;
                
            }else if(path.get(i).left == path.get(i+1)){
                currDir = 1;
                
            }else if(path.get(i+1).left == path.get(i)){
                currDir = 1;
                
            } else currDir = 2;
            
            if(preDir != 0 && preDir != currDir) turns++;
            
            preDir = currDir;
        }
        
        return turns == 0 ? -1 : turns;
        
    }
    
    public boolean rootToTar(ArrayList<Node> path, Node root, int tar){
        
        if(root == null) return false;
        
        path.add(root);
        
        if(root.data == tar) return true;
        
        boolean left = rootToTar(path, root.left, tar);
        
        if(left == true) return true;
        
        boolean right = rootToTar(path, root.right, tar);
        
        if(right == false) path.remove(path.size()-1);
        
        return right;
        
        
    }
}
