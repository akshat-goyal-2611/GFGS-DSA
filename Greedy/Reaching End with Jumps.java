class Solution {
    public boolean canReach(int[] arr) {
        
        int n = arr.length;
        
        int maxJump = 0;
        
        for(int i = 0; i < n; i++){
            
            if(maxJump < i) return false;
            
            maxJump = Math.max(maxJump, arr[i]+i);
        }
        
        return true;
    }
}
