class Solution {
    public int maxSubarraySum(int[] arr, int k) {
       
       int n = arr.length;
       
       int preSum = 0;
       
       for(int i = 0; i < k; i++){
            preSum += arr[i];    
       }
       
       int maxSum = preSum; 
       
       for(int i = k; i < n; i++){
           
           preSum = preSum + arr[i] - arr[i-k];
           
           maxSum = Math.max(maxSum, preSum);
       }
       
       return maxSum;
       
    }
}
