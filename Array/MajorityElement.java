class Solution {
    int majorityElement(int arr[]) {
       
       int n = arr.length;
       
       int cand = arr[0];
       
       int cnt = 1;
       
       for(int i = 1; i < n; i++){
           
           if(cnt == 0){
               cand = arr[i];
           }
           
           if(arr[i] == cand){
               cnt++;
           }else{
               cnt--;
           }
       }
       
       cnt = 0;
       for(int ele : arr){
           if(ele == cand) cnt++;
       }
       
       return cnt > n/2 ? cand : -1;
    }
}
