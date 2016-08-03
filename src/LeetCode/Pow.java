package LeetCode;

/**
 * Created by guozhongxin on 16/7/20.
 */
public class Pow {
	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.myPow(2.5d,3));
	}
	public double myPow(double x, int n) {
		long absn = Math.abs((long)n);
		if (x ==1d){
			return 1;
		}

		double res = pow(x,absn);
		return (n>=0)? res:1/res;
	}

	public double pow(double x, long n){
		if (n ==0){
			return 1;
		}
		if (n ==1){
			return x;
		}
		double half = pow(x, n>>1);
		return (n%2 ==1)? half*half*x: half*half;
	}

}
