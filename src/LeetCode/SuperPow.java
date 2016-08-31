package LeetCode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by dell on 2016/8/6.
 */
public class SuperPow {
    int base = 1337;
    public int superPow(int a, int[] b) {
        int remainer = 1;
        for (int i =0; i< b.length; i++){
            remainer = (powmod(remainer, 10) * powmod(a, b[i]))%base;
        }

        return (int)remainer;
    }
    int powmod(int a, int b){
        int remainer = 1;
        a = a%base;
        for (int i = 0; i<b; i++){
            remainer = (remainer * a)%base;
        }
        return remainer ;
    }

    void test(){
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
    }
}
