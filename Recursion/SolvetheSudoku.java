class Solution {
    static boolean flag;
    public void solveSudoku(int[][] mat) {
        
        flag = false;
        
        int n = mat.length;
        
        recur(mat, 0, 0, n);
        
    }
    
    public void recur(int[][] mat, int row, int col, int n){
        
        if(row == n) {
            flag = true;
            return;
        }
        
        if(mat[row][col] == 0){
            
            for(int digit = 1; digit <= 9; digit++){
                
                boolean isSameRowCol = checkRAndC(mat, row, col, n, digit);
                boolean isSameGrid = checkGrid(mat, row, col, digit);
                
                if(!isSameRowCol && !isSameGrid){
                    
                    mat[row][col] = digit;
                    
                    if(col != n-1)
                        recur(mat, row, col+1, n);
                    else recur(mat, row+1, 0, n);
                    
                     if(flag) return;
                    
                    mat[row][col] = 0;
                }
            }
        }
        
        else {
            if(col != n-1)
                recur(mat, row, col+1, n);
            
            else
                recur(mat, row+1, 0, n);
        
           
        }
        
        
    }
        
        public boolean checkRAndC(int[][] mat, int row, int col, 
        int n, int digit){
            
            // check in row
            for(int j = 0; j < n; j++){
                if(mat[row][j] == digit) return true;
            }
            
            // check in  col
             for(int i = 0; i < n; i++){
                if(mat[i][col] == digit) return true;
            }
            
            return false;
            
        }
        
        public boolean checkGrid(int[][] mat, int row, int col, 
        int digit){
            
            
            int i = (row/3)*3;
            int j = (col/3)*3;
            
            for(int x = i; x < i + 3; x++){
                for(int y = j; y < j+3; y++){
                    if(mat[x][y] == digit) return true;
                }
            }
            
            return false;
        }
    }
