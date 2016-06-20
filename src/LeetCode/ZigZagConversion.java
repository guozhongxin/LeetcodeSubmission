package LeetCode;

/**
 * Created by guozhongxin on 15/9/24.
 */
public class ZigZagConversion {

	public static String convert_1(String s, int numRows) {

		int length = s.length();
		if (numRows==1){
			return s;
		}
		int column = (length/(numRows*2-2)+1)*2;
		char[][] zz = new char[numRows][column];
		int[] iRow = new int[numRows];
		for (int i =0; i<numRows;i++){
			iRow[i]=0;
		}

		for (int i = 0; i<length; i++){
			int remainder = i%(2*numRows-2);
			int row=0;
			if(remainder<numRows) {
				row = remainder;
			}else {
				row = 2*numRows-remainder-2;
			}
			zz[row][iRow[row]]=s.charAt(i);
			iRow[row]+=1;
		}

		String zzs = "";
		for (int i =0; i<numRows;i++){
			for (int j = 0; j<iRow[i];j++){
				zzs+=zz[i][j];
			}
		}
		return zzs;
	}

	public static String convert_2(String s, int numRows) {

		int length = s.length();
		if (numRows==1){
			return s;
		}
		int column = (length/(numRows*2-2)+1)*2;
		char[][] zz = new char[numRows][column];
		int[] iRow = new int[numRows];
		for (int i =0; i<numRows;i++){
			iRow[i]=0;
		}

		for (int i = 0; i<length; i++){
			int remainder = i%(2*numRows-2);
			int row= numRows-1-Math.abs(remainder-numRows+1);
//			if(remainder<numRows) {
//				row = remainder;
//			}else {
//				row = 2*numRows-remainder-2;
//			}
			zz[row][iRow[row]]=s.charAt(i);
			iRow[row]+=1;
		}

		String zzs = "";
		for (int i =0; i<numRows;i++){
			zzs+= new String(zz[i],0,iRow[i]);
			for (int j = 0; j<iRow[i];j++){
//				zzs+=zz[i][j];
			}
		}
		return zzs;
	}

	public static String convert(String s, int numRows) {

		int length = s.length();
		if (numRows==1){
			return s;
		}
//		int column = (length/(numRows*2-2)+1)*2;
		String[] zz = new String[numRows];
//		ArrayList<ArrayList<Character>> zz = new ArrayList<ArrayList<Character>>();
//		int[] iRow = new int[numRows];
//		for (int i =0; i<numRows;i++){
//			iRow[i]=0;
//		}

		for (int i = 0; i<length; i++){
			int remainder = i%(2*numRows-2);
			int row= numRows-1-Math.abs(remainder-numRows+1);
//			if(remainder<numRows) {
//				row = remainder;
//			}else {
//				row = 2*numRows-remainder-2;
//			}
			zz[row]+=s.charAt(i);
		}

		String zzs = "";
		int min = numRows>length?length:numRows;
		for (int i =0; i<min;i++){
			zzs+= new String(zz[i]);
		}
		return zzs.substring(4);
	}


	public static void main(String[] args) {
		String s = "sdgfjsfj1";
		System.out.println(convert(s,3));
	}
}
