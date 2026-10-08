
class Solution {
    boolean isCompleteBT(Node root) {
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        boolean isNullFound = false;
        
        while(!q.isEmpty()){
            
            Node node = q.remove();
            
            if(node.left != null){
                
                if(isNullFound) return false;
                
                q.add(node.left);
            }else{
                isNullFound = true;
            }
            
            if(node.right != null){
                
                if(isNullFound) return false;
                
                q.add(node.right);
            }else{
                
                isNullFound = true;
            }
        }
        
        return true;
    }
}
