class Solution {
	static boolean flag;
	
	public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
		
		
		if (mat[0][0] == 0) {
			
			ArrayList<ArrayList<Integer>> ans = new 
			ArrayList<>();
			ArrayList<Integer> r = new ArrayList<>();
			r.add(-1);
			ans.add(r);
			return ans;
		}
		
		flag = false;
		
		int m = mat.length;
		int n = mat[0].length;
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> row = new ArrayList<>(
			Collections.nCopies(n, 0));
			res.add(row);
		}
		
		
		
		int[][] hel = new int[m][n];
		
		solve(mat, 0, 0, hel, res, n);
		
		if (!flag) {
			
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			ArrayList<Integer> r = new ArrayList<>();
			r.add(-1);
			ans.add(r);
			return ans;
			
		}
		
		return res;
		
	}
	
	public void solve(int[][] mat, int row, int col,
	int[][] hel, ArrayList<ArrayList<Integer>> res, int n) {
		
		if (row == n - 1 && col == n - 1) {
			res.get(row).set(col, 1);
			flag = true;
			return;
		}
		
		for (int i = 1; i <= mat[row][col] && i < n; i++) {
			
			// right jump
			if (col + i < n) {
				if (mat[row][col + i] != 0 && hel[row][col + i] == 0) {
					
					res.get(row).set(col, 1);
					solve(mat, row, col + i, hel, res, n);
					
					if (!flag)
						res.get(row).set(col, 0);
					else
						return;
				}
			}
			
			// down jump
			if (row + i < n) {
				if (mat[row + i][col] != 0 && hel[row + i][col] == 0) {
					
					res.get(row).set(col, 1);
					
					solve(mat, row + i, col, hel, res, n);
					
					if (!flag)
						res.get(row).set(col, 0);
					else
						return;
				}
			}
			
		}
		
		hel[row][col] = 1;
		return;
		
	}
}
