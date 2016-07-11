package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by guozhongxin on 16/7/7.
 */
public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.print(gp.generateParenthesis(2));

		PriorityQueue<Integer> a = new PriorityQueue<Integer>();
		a.add(1);
		a.add(5);
		a.add(4);
		a.add(2);
		System.out.println(a.poll());
		System.out.println(a);
	}
	public List<String> generateParenthesis(int n) {
		LinkedList<String> well = new LinkedList<String>();
		StringBuilder sb = new StringBuilder("");
		recurseGetP(well, 0,0,n, "");
		return well;
	}
	public void recurseGetP (LinkedList<String> well, int left, int right,int n, String prefix){
		if (left == n){
			StringBuilder sb = new StringBuilder(prefix);
			for (int i =0; i<(n-right); i++) {
				sb.append(")");
			}
			well.add(sb.toString());
			return;
		}
		if (left>right){

			recurseGetP(well, left+1, right, n, prefix+"(");
			recurseGetP(well, left, right+1, n, prefix+")");
		}else if (left==right){
			recurseGetP(well, left+1, right, n, prefix+"(");
		}


	}
}

