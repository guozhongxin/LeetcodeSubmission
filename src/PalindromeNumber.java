/**
 * Created by dell on 2015/11/26.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String s = x+"";
        String reversS = "";
        int subLength = s.length()/2;
        if (s.charAt(0)=='-'){
            return false;
        }

        for (int i =s.length() -1 ;i>=s.length()-subLength; i--){
            reversS +=s.charAt(i);
        }
        if (reversS.equals(s.substring(0,subLength))){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args){
        System.out.println(isPalindrome(12));
//        System.out.println("012345".substring(0,2));
    }
}
