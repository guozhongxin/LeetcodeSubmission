package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dell on 2016/9/7.
 */
public class RestoreIPAddresses {
    public static void main(String[] a){
        RestoreIPAddresses r = new RestoreIPAddresses();
        System.out.println(r.restoreIpAddresses("10201112"));
    }
    public List<String> restoreIpAddresses(String s) {
        int[] address = new int[4];
        LinkedList<String> res = new LinkedList<String>();
        translate(res, s, address, 0, 0);

        return res;
    }

    private void translate(LinkedList<String> res, String s, int[] address, int addressIndex, int sIndex) {
        int sLength = s.length();

        if (addressIndex==4){
            if (sIndex == sLength){
                res.add(address[0]+"."+address[1]+"."+address[2]+"."+address[3]);
            }else {
                return;
            }
        }
        if ((sLength-sIndex) > 3*(4-addressIndex) || sIndex >= sLength){
            return;
        }

        int minSize = Math.max(1, (sLength-sIndex-3*(3-addressIndex)));
        int maxSize = Math.min(3, (sLength-sIndex-(3-addressIndex)));
        if (s.charAt(sIndex)-'0' ==0){
            minSize = 1;
            maxSize = 1;
        }
        for (int i = minSize; i<=maxSize; i++){
            int subAddress = Integer.valueOf(s.substring(sIndex, sIndex+i));
            if (subAddress>255){
                continue;
            }
            address[addressIndex] = subAddress;
            translate(res, s, address, addressIndex+1, sIndex+i);
        }

    }
}
