package Quiz;

import java.util.Scanner;

/**
 * Created by dell on 2016/9/5.
 */
public class jingjiao1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNext()){
            n = sc.nextInt();
            int[] height = new int[n];

            for (int i =0; i<n; i++){
                height[i] = sc.nextInt();
            }
            int res = compute(height);
            System.out.println(res);
        }
    }

    private static int compute(int[] height){
        int res = 0;
        int n = height.length;
        res += n;
        for (int i = 0; i<n-1; i++){

            for (int j = i+2; j< n; j++){
                if (i==0 && j== n-1){
                    break;
                }
                int a = height[i];
                int b = height[j];
                int min = Math.min(height[i], height[j]);
                boolean left = true;
                for (int x = i+1; x<= j-1; x++){
                    if (height[x] > min){
                        left = false;
                        break;
                    }
                }
                if (left){
                    res++;
                    continue;
                }
                boolean right = true;
                for (int x = j+1; x<=(n-1+i); x++){
                    if (height[x%n]>min){
                        right = false;
                        break;
                    }
                }
                if (right){
                    res++;
                }

            }
        }
        return res;
    }
}
