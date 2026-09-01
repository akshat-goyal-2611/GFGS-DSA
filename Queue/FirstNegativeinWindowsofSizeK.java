class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
      
      Queue<Integer> q = new LinkedList<>();
      
      int n = arr.length;
      List<Integer> res = new ArrayList<>();
      
      for(int i = 0; i < k; i++){
          if(arr[i] < 0) q.add(i);
      }
      
      if(q.isEmpty()) res.add(0);
        else res.add(arr[q.peek()]);
      
      for(int i = k; i < n; i++){
          
          if(!q.isEmpty() && q.peek() == i-k){
              q.remove();
          }
          
          if(arr[i] < 0) q.add(i);
          
          if(q.isEmpty()) res.add(0);
          else res.add(arr[q.peek()]);
          
      }
      
      return res;
        
    }
}
