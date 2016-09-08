package Quiz;

import java.util.Scanner;

/**
 * Created by dell on 2016/9/5.
 */
public class jd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a;
        while (sc.hasNext()){
            a = sc.nextInt();
            String res = compute(a);
            System.out.println(res);
        }
    }
    private static String compute(int a){
        int ssum = 0;
        for (int i =2; i<= a-1;i++){
            int k = a/i;
            ssum+=a%i;
            while (k/i!=0){
                ssum+=k%i;
                k = k/i;
            }
            ssum+=k;
        }
        int m = ssum;
        int n = a-2;
        int tmp;
        while (m%n!=0){
            tmp = m%n;
            m = n;
            n = tmp;
        }
        return ssum/n +"/" +(a-2)/n;
    }
}
