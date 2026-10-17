class Solution {
    public int startStation(int[] gas, int[] cost) {
        
        int n = gas.length;
        
        int currGas = 0;
        
        int stStation = 0;
        
        for(int i = 0; i < n; i++){
            
            currGas = currGas + gas[i] - cost[i];
            
            if(currGas < 0){
                stStation = i+1;
                currGas = 0;
            }
        }
        
        if(stStation >= n) return -1;
        
        for(int i = 0; i < stStation; i++){
            
            currGas = currGas + gas[i] - cost[i];
            
            if(currGas < 0) return -1;
            
        }
        
        return stStation;
        
    }
}
