class Solution {
    public boolean isPowerofTwo(int n) {
        
        if(n == 0) return  false;
        
        return ((n)&(n-1)) == 0 ? true : false;
        
    }
}
