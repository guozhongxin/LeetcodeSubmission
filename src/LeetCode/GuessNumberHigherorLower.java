package LeetCode;

/**
 * Created by dell on 2016/8/6.
 */
public class GuessNumberHigherorLower {

    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        int g = start + (end-start)/2;
        while (true){
            int r = guess(g);
            if (r==-1){
                end = g-1;
            }else if(r==1){
                start = g+1;
            }else if( r ==0){
                break;
            }
            g = start + (end-start)/2;
        }
        return g;
    }

    int guess(int num){
        return 1;
    }
}
