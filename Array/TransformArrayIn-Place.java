class Solution {
    public void arrange(int[] arr) {
       
         int n = arr.length;
         
         for(int i = 0; i < n; i++){
             
             int oldVal = arr[i];
             int newVal = (arr[arr[i]]%n);
             
             arr[i] = (newVal*n) + oldVal;
         }
         
         for(int i = 0; i < n; i++){
             arr[i] = (arr[i]/n);
         }
         
         
    }
}
