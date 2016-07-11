/**
 * Created by guozhongxin on 15/11/28.
 */
public class RegularExpressionMatching {

	public static boolean isMatch(String s, String p) {

		char[] ss = s.toCharArray();
		char[] pp = p.toCharArray();

		int si =0;int pi=0;
//		if (p.contains(".*")) {
//			return true;
//		}
		for (;pi<pp.length && si<ss.length;){
			if (ss[si]==pp[pi] || pp[pi]=='.'){
				pi++;
				si++;
				if (pi<pp.length && si<ss.length) {
					if (pp[pi] == '*') {
							while ( si<ss.length && (ss[si] == pp[pi - 1] || pp[pi - 1] == '.' )) {
								si ++;
							}
						pi++;
					}
				}
			}else {
				if ( pi+1 < pp.length && pp[pi+1]=='*'){
					pi+=2;
				}else{
					return false;
				}
			}
		}

		if(si == ss.length) {

			if (pi == pp.length) {
				return true;
			} else if(pi+1<pp.length) {
				if (pp[pi]=='*'){
					pi++;
				}
				while (pi+1<pp.length){
					if (pp[pi+1]!='*'){
						return false;
					}
					pi+=2;
				}
				return true;
			}
		}


		return false;
	}


	public static void main(String[] args) {
		System.out.println(isMatch("aaa","a*a"));
//		System.out.println(isMatch("aa","aa"));
//		System.out.println(isMatch("aaa","aa"));
//		System.out.println(isMatch("aa", "a*"));
//		System.out.println(isMatch("aa", ".*"));
//		System.out.println(isMatch("ab", ".*"));
//		System.out.println(isMatch("aab", "c*a*b"));
//		System.out.println(isMatch("aab", "a*"));
//		System.out.println(isMatch("aabc", "a*b*c*spd*"));
//		System.out.println(isMatch("ab", ".*c"));

	}
}
