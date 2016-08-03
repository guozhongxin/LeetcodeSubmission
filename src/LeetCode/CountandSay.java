package LeetCode;

/**
 * Created by guozhongxin on 16/7/16.
 */
public class CountandSay {
	public static void main(String[] args) {
		CountandSay cs = new CountandSay();
		System.out.print(cs.countAndSay(5));
	}
	public String countAndSay(int n) {
		String s = "1";
		for (int i =1; i<= n-1 ; i++){
			s = count(s);
		}
		return s;
	}

	private String count(String s) {
		StringBuilder sb = new StringBuilder();
		char current =s.charAt(0);
		int currentNum =1;
		for (int i=1; i< s.length(); i++){
			char c = s.charAt(i);
			if (c == current){
				currentNum++;
			}else {
				sb.append(currentNum);
				sb.append(current);
				current = c;
				currentNum =1;
			}
		}
		sb.append(currentNum);
		sb.append(current);
		return sb.toString();
	}

}
