package OnlineTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dell on 2016/9/6.
 */
public class lifeng {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] table = new int[n];
        int[] men = new int[m];
        int[] money = new int[m];
        for (int i = 0; i<n ; i++){
            table[i] = sc.nextInt();
        }
        for (int i = 0; i<m; i++){
            men[i] = sc.nextInt();
            money[i] = sc.nextInt();
        }
        System.out.println(compute(table, men, money));
    }
    private static int compute(int[] table, int[] men, int[] money){
        boolean[] take = new boolean[men.length];
        Arrays.fill(take, false);
        Arrays.sort(table);
        int sum = 0;
        for (int i = 0; i< table.length;i++){
            int maxMen = table[i];
            int menIndex = -1;
            int maxMoney = -1;
            for (int j = 0; j < men.length ; j++){
                if (men[j]> maxMen || take[j]){
                    continue;
                }
                if (money[j]> maxMoney){
                    menIndex = j;
                    maxMoney = money[j];
                }
            }
            if (maxMoney != -1){
                take[menIndex] = true;
                sum += money[menIndex];
            }

        }
        return sum;
    }
}
