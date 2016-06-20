package LeetCode;

/**
 * Reverse digits of an integer.
 * 		Example1: x = 123, return 321
 * 		Example2: x = -123, return -321
 *
 * Created by guozhongxin on 15/11/5.
 */
public class ReverseInteger {

	/**
	 * reverse (runtime beats 21.40% of java submissions)
	 * @param x
	 * @return
	 */
	public static int reverse_1(int x) {
		int[] digit = new int[11];
		boolean zheng = (x>=0);
		int p=Math.abs(x),q=0;
		int i=0;
		for(; i <= 11 && p!=0; i++){
			q = p/10;
			digit[i] = p%10;
			p=q;
		}
		i--;
		long r = 0l;
		for (int j =i; j>=0; j--){
			r+=Math.pow(10, i - j)*digit[j];
		}
		if (!zheng){
			r=0l-r;
		}
		if (r>Integer.MAX_VALUE||r<Integer.MIN_VALUE){
			return 0;
		}else{
			return (int)r;
		}
	}


	public static void main(String[] args) {
	}
}
