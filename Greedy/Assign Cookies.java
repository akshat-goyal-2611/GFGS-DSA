class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        
        Arrays.sort(greed);
        Arrays.sort(cookie);
        
        
        int i = 0, j = 0;
        
        int n = greed.length;
        
        while(i < n && j < cookie.length){
            
            if(cookie[j] >= greed[i]){
                i++; j++;
            }else{
                j++;
            }
        }
        
        return i;
    }
}
