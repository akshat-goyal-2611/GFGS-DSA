class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        
        for(int i = 0; i < k; i++){
            
            while(!dq.isEmpty() && 
            arr[i] >= arr[dq.peekLast()]){
                
                dq.removeLast();
            }
            
            dq.addLast(i);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        res.add(arr[dq.peekFirst()]);
        
        
        for(int i = k; i < n; i++){
            
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }
            
             while(!dq.isEmpty() && 
            arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            
            dq.addLast(i);
            
            res.add(arr[dq.peekFirst()]);
        }
        
        return res;
        
    }
}
