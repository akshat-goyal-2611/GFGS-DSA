class Solution {
    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int tar) {
       
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       
       ArrayList<Integer> curr = new ArrayList<>();
       
       Arrays.sort(arr);
       
       solve(curr, 0, res, 0, tar, -1, arr, arr.length);
       return res;
        
    }
    
    public void solve(ArrayList<Integer> curr, int sum, 
    ArrayList<ArrayList<Integer>> res, int idx, int tar, int lastEle,
    int []arr, int n){
        
        if(sum > tar) return;
        
        if(sum == tar){
            
            ArrayList<Integer> ans = new ArrayList<>(curr);
            res.add(ans);
            
            return;
        }
        
        for(int i = idx; i < n; i++){
            
            if(lastEle == arr[i]) continue;
            
            curr.add(arr[i]);
            solve(curr, sum+arr[i], res, i+1, tar, -1, arr, n);
            
            curr.remove(curr.size()-1);
            
            lastEle = arr[i];
        }
       
    }
}
