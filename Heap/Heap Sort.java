class Solution {
  
    public void heapSort(int arr[]) {
        
        
        // make max- heap
        int n = arr.length;
        
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(arr, i, n);
        }
        
        for(int i = n-1; i > 0; i--){
            
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            
            heapify(arr, 0, i);
        }
        
    }
    
    public void heapify(int[] arr, int i, int n){
        
        
        int left = 2*i+1;
        int right = 2*i+2;
        
        int largest = i;
        
        if(left < n && arr[left] > arr[largest]) largest = left;
        if(right < n && arr[right] > arr[largest]) largest = right;
        
        if(largest == i) return;
        
        int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
        
        heapify(arr, largest, n);
        
    }
}
