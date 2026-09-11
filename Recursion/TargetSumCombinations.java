class Solution {
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int tar) {
        
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        ArrayList<Integer> curr = new ArrayList<>();
        
        generateArr(curr, 0, tar, res, 0, arr);
        
        return res;
    }
    public void generateArr(ArrayList<Integer> curr, int sum, int tar,
    ArrayList<ArrayList<Integer>> res, int i, int[] arr){
        
        
        if(i >= arr.length || sum > tar) return;
        
        if(sum == tar){
            
            ArrayList<Integer> ans = new ArrayList<>(curr);
            res.add(ans);
            return;
            
        }
        
        curr.add(arr[i]);
        sum += arr[i];
        
     generateArr(curr, sum, tar, res, i, arr);
     
     curr.remove(curr.size()-1);
     sum -= arr[i];
     
     generateArr(curr, sum, tar, res, i+1, arr);
     
    }
}
