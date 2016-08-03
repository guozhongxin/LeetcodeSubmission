package LeetCode;

/**
 * Created by guozhongxin on 16/7/16.
 */
public class ValidSudoku {
	public static void main(String[] args) {
		System.out.print('.'-'1');
	}

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
						char c = board[i][j];
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
		return  true;
	}
}
