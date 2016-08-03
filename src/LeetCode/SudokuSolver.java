package LeetCode;

/**
 * Created by guozhongxin on 16/7/16.
 */
public class SudokuSolver {
	public static void main(String[] args) {
		char[][] board = new char[][]{"..9748...".toCharArray(),"7........".toCharArray(),".2.1.9...".toCharArray(),
				"..7...24.".toCharArray(),".64.1.59.".toCharArray(),
				".98...3..".toCharArray(),"...8.3.2.".toCharArray(),
				"........6".toCharArray(),"...2759..".toCharArray()};

		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(board);
	}
	public void solveSudoku(char[][] board) {
		solve(board);
	}


	// think about every if and every else
	// each solve in recurse just handle one piece in Sudo. So need not the for-for
	private boolean solve(char[][] board){
		boolean canbeSolved = true;
		for(int i =0; i<9; i++){
			for(int j =0; j<9; j++){
				char c = board[i][j];
				if (c == '.'){
					for (char s = '1'; s<='9'; s++){
						board[i][j] = s;
						if (isValidSudoku(board)) {   // the point!!!
							if (!solve(board)) {     // the point!!!
								board[i][j]='.';     // the point!!!
							}else {
								return true;        // the point!!!
							}
						}else {
							board[i][j] = '.';       // the point!!!
						}
					}
					if (board[i][j] == '.'){
						return false;
					}
				}
			}

		}
		return true;
	}

	private boolean isSolved(char[][] board) {
		for(int i =0; i<9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c == '.') {
					return false;
				}
			}
		}
		return true;
	}


	//just need to validate the new value!
	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++){
			int[] index = new int[9];

			int[] index2 = new int[9];
			for(int j = 0; j<9; j++){
				char c = board[i][j];
				if (c!='.'){
					if (index[c-'1']==0) {
						index[c - '1'] = 1;
					}else {
						return false;
					}
				}

				char c2 = board[j][i];
				if (c2!='.'){
					if (index2[c2-'1']==0) {
						index2[c2 - '1'] = 1;
					}else {
						return false;
					}
				}
			}
		}
		for (int i = 0; i< 9; i+=3){
			for (int j =0; j<9; j+=3){
				int[] index = new int[9];
				for (int n = i; n<i+3; n++){
					for (int m= j; m<j+3; m++){
						char c = board[n][m];
						if (c!='.'){
							if (index[c-'1']==0) {
								index[c - '1'] = 1;
							}else {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}


}
