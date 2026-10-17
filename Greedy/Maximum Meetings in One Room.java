class Solution {
	public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
		
		int n = s.length;
		
		ArrayList<int[]> arr = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			
			arr.add(new int[] {s[i], f[i], i});
		}
		
		arr.sort(Comparator.comparingInt(a->a[1]));
		
		ArrayList<Integer> res = new ArrayList<>();
		
		res.add(arr.get(0)[2]+1);
		
		for (int i = 1; i < n; i++) {

            int prevEnd = f[res.get(res.size()-1)-1];
            int currSt = arr.get(i)[0];
			
			if (currSt > prevEnd) {
				
				res.add(arr.get(i)[2]+1);
			}
			
		}
		
		Collections.sort(res);
		
		return res;
	}
}
