class Solution {
    public int median(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; i++){
            
            s = Math.min(s, mat[i][0]);
            e = Math.max(e, mat[i][n-1]);
        }
        
        int ans = s;
        
        while(s <= e){
            
            int mid = s + (e-s)/2;
            int left = leftCnt(mat, mid);
            
            if( left >= (m*n)-left){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
            
        }
        
        return ans;
    }
    
    public int leftCnt(int[][] mat, int mid){
        
        int cnt = 0;
        
        for(int i = 0; i < mat.length; i++){
            
            for(int j = 0; j < mat[i].length; j++){
                
                if(mat[i][j] > mid) break;
                cnt++;
            }
            
        }
        
        return cnt;
    }
}
