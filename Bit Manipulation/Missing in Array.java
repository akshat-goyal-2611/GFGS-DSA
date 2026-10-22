class Solution {
    int missingNum(int arr[]) {
       
       int n = arr.length;
       
       int ans = 0;
       for(int i = 0; i < n; i++){
           
           ans ^= arr[i];
       }
       
       for(int i = 1; i <= n+1; i++){
           ans ^= i;
       }
       
       return ans;
    }
}
