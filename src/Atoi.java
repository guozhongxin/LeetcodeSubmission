/**
 * Created by guozhongxin on 15/11/5.
 */
public class Atoi {
	/**
	 * myatoi
	 * @param s string ("", " ", "0","+-" 之间的组合)
	 * @return int
	 */
	public static int myatoi_1(String s){
		int a =0;
		int length = s.length();
		if (length ==0){
			return 0;
		}
		boolean zheng = true; int j =0;
		for(;j<length;j++){
			if (s.charAt(j)!=' ')
				break;
		}
		char first = s.charAt(j);
		if ( first =='+' ){
			j++;
		}else if (first == '-'){
			j++;
			zheng=false;
		}
		int p=0;
		if (zheng){
			for (int i =0; i<length-j; i++){
				char c = s.charAt(length-i-1);
				if ( '0'<=c && c<='9'){
					if ((c-'0')*Math.pow(10,i-p) < Integer.MAX_VALUE-a)
						a+=(c-'0')*Math.pow(10,i-p);
					else
						a = Integer.MAX_VALUE;
					// }else if (c==' '){
					// 	for (int x = 0 ; x<length-i-1;x++){
					// 		if (s.charAt(x)!=' '){
					// 			return 0;
					// 		}
					// 	}
					// 	return a;
				}else {
					//return 0;
					a=0;
					p=i+1;
				}
			}
		}else {
			for (int i =0; i<length-j; i++){
				char c = s.charAt(length-i-1);
				if ( '0'<=c && c<='9'){
					if ((c-'0')*Math.pow(10,i-p) <= a-1-Integer.MIN_VALUE) // 0-Integer.MIN_VALUE = Integer.MIN_VALUE!!!!
						a-=(c-'0')*Math.pow(10,i-p);
					else
						a = Integer.MIN_VALUE;
					// }else
					// if (c==' '){
					// 	for (int x = 0 ; x<length-i-1;x++){
					// 		if (s.charAt(x)!=' '){
					// 			return 0;
					// 		}
					// 	}
					// 	return a;
				}else {
					// 	return 0;
					a=0;
					p=i+1;
				}
			}
		}
		return a;

	}

	public static int myatoi(String str){
		int a = 0;
		int[] nums = new int[11];int n = 0;
		boolean zheng = true;
		int length = str.length();
		int i = 0;
//		for ()
//		for (int i = 0;i<length; i++){
//			char c = str.charAt(i);
//			if (c==' ')
//		}
		return 0;
	}

	public static void main(String[] args) {
//		System.out.print(-1-Integer.MIN_VALUE);
		System.out.print(myatoi("-000000000006789"));
	}
}
