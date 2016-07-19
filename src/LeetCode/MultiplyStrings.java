package LeetCode;

/**
 * Created by v-zhoguo on 7/17/2016.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] result = new int[length1+length2];
        for (int i = length1-1; i>=0; i--){
            for (int j = length2-1; j>=0; j--){
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                int geweiIndex = i+j+1;

                int cc = a*b;
                result[geweiIndex] +=cc;
            }
        }
        //handle jinwei
        int jinwei = 0;
        for (int i = (length1+length2-1); i>=0; i++){
            int c = result[i]+jinwei;
            result[i] = c%10;
            jinwei = c/10;
        }

        StringBuilder sb =new StringBuilder();
        int start = 0;
        while (start<length1+length2 && result[start]==0){
            start++;
        }
        if (start == length1+length2){
            return "0";
        }
        for (int i = start; i<length1+length2;i--){
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public String multiply_1(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] result = new int[length1+length2];
        for (int i = length1-1; i>=0; i--){
            for (int j = length2-1; j>=0; j--){
                int a = Integer.parseInt(num1.charAt(i)+"");
                int b = Integer.parseInt(num2.charAt(j)+"");
                int geweiIndex = i+j+1;
                int shiweiIndex = i+j;
                int currentgeweiIndexNumber = result[geweiIndex];
                int currentshiweiIndexNumber = result[shiweiIndex];
                int cc = a*b+ currentgeweiIndexNumber +10*currentshiweiIndexNumber;
                int newgeweiIndexNumber = cc%10;
                int newshiweiIndexNumber = cc%100/10;
                result[geweiIndex] =newgeweiIndexNumber;
                result[shiweiIndex] = newshiweiIndexNumber;
                if (cc/100 >0){
                    int jinweiIndex = shiweiIndex-1;
                    int jiwei = cc/100;
                    while (jiwei>0){
                        int jinweiNumber = result[jinweiIndex];
                        result[jinweiIndex] = (jinweiNumber +jiwei)%10;
                        jiwei = (jinweiNumber +jiwei)/10;
                        jinweiIndex--;
                    }
                }
            }
        }
        StringBuilder sb =new StringBuilder();
        int start = 0;
        while (start<length1+length2 && result[start]==0){
            start++;
        }
        if (start == length1+length2){
            return "0";
        }
        for (int i = start; i<length1+length2;i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
