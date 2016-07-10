package utils;

/**
 * Created by v-zhoguo on 7/10/2016.
 */
public class Test {
    public static void main(String[] args){
//        int[] a = new int[3];
//        System.out.print(a[0]);
//        System.out.print(a[1]);
//        System.out.print(a[2]);
        Double a = -1d;
        String as = a.toString();
        String result = "";
        if (as.replace("-", "").length()>=14){
            result = as.substring(0,14);
        }else {
            while (as.replace("-", "").length()<14){
                as+='0';
            }
            result= as;
        }
        System.out.print(result);
    }
}
