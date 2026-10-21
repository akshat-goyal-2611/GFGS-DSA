class Solution {
    // Function to count the number of subarrays with a sum that is divisible by K
    public int subCount(int[] arr, int k) {
        
        int n = arr.length;
        
        HashMap<Long, Integer> mp = new HashMap<>();
        int cnt = 0;
        
        long sum = 0;
        
        for(int i = 0; i < n; i++){
            
            sum += arr[i];
            
            long x = sum%k;
            
            if(x < 0){
                x = (sum%k) + k;
            }
            
            if(mp.containsKey(x)){
                
                cnt += mp.get(x);
            }
            
            if(x == 0) cnt++;
            
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }
        
        return cnt;
    }
}
