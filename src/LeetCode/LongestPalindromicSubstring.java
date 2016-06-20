package LeetCode;

/**
 * Created by guozhongxin on 15/9/23.
 */
public class LongestPalindromicSubstring {
	public static String longestPalindrome_1(String s) {

		int length = s.length();

		int longest = 0;
		String ll = "";
		for (int i = 0; i<length-1; i++){
			for (int j = i+1; j<length ; j++){
				String subString = s.substring(i,j+1);
				int l = judgePalindrome(subString);
				longest = (longest>l)?longest:l;
				ll=(longest>l)?ll:subString;
				System.out.print("");
			}
		}

		return ll;
	}

	public static int judgePalindrome(String s) {
		int length = s.length();
		int halfLength = Math.round(length / 2);
		for (int i = 0; i<halfLength; i++){
			if (s.charAt(i) != s.charAt(length-1-i)){
				return 0;
			}
		}
		return length;
	}

	public static String longestPalindrome(String s){
		int length = s.length();
		int longest = 1;
		String longestPalindrome = s.substring(0, 1);

		for (int i =0; i<= 2*length-1 ; i++){
			int end = i/2+1;
			int start = i-end;
//			int bound = (start>(length-1-end))?start:(length-1-end);
			while ( start>= 0 && end<length ){
				if (s.charAt(start)==s.charAt(end)){
					int l = end-start+1;
					if(longest < l){
						longest = l;
						longestPalindrome = s.substring(start,end+1);
					}
				}else{
					break;
				}
				--start;
				++end;
			}
		}

		return longestPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aabaaaaa"));
//		System.out.println("01234".substring(4,5));
	}
}
