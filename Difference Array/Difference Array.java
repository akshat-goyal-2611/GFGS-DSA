class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
       
       int n = arr.length;
       // create a difference array
       int[] dArr = new int[n+1];
        
        for(int i = 0; i < opr.length; i++){
            
            int l = opr[i][0];
            int r = opr[i][1];
            int val = opr[i][2];
            
            dArr[l] += val;
            dArr[r+1] -= val;
        }
        
        int currSum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            
            dArr[i] = dArr[i] + currSum;
            res.add(arr[i]+dArr[i]);
            
            currSum = dArr[i];
        }
        
        return res;
    }
}
