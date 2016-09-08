package LeetCode;

/**
 * Created by dell on 2016/9/4.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        if (word.length()==0){
            return true;
        }
        int m = board.length;
        if (m==0){
            return false;
        }
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i< m; i++){
            for (int j = 0;j< n ; j++){
                if (dfs(board, words, 0, i, j, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int index, int i, int j, boolean[][] visited) {
        if (index>words.length-1){
            return true;
        }
        if (i<0 || i>board.length-1){
            return false;
        }
        if (j<0 || j> board[0].length-1){
            return false;
        }
        if (visited[i][j]){
            return false;
        }
        if (board[i][j] == words[index]){
            visited[i][j] = true;
            boolean res =  dfs(board, words, index+1, i, j+1, visited) ||
                    dfs(board, words, index+1, i+1, j, visited) ||
                    dfs(board, words, index+1, i-1, j, visited) ||
                    dfs(board, words, index+1, i, j-1, visited);
            if (!res){
                visited[i][j] = false;
            }
            return res;
        }else {
            return false;
        }
    }
}
