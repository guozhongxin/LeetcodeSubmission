package Quiz;

import java.io.*;

/**
 * Created by zhongxin on 7/10/2016.
 */
public class GoogleTest3 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\v-zhoguo\\Desktop\\C-small-attempt0.in";
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int caseNumber = Integer.parseInt(br.readLine());

        String outPath = "C:\\Users\\v-zhoguo\\Desktop\\out.txt";
        File outFile = new File(outPath);
        FileWriter fw = new FileWriter(outFile);

        for (int i = 0; i < caseNumber; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] numbers = new int[m+1];
            String[] cs = br.readLine().split(" ");
            for(int j =0; j< m+1; j++){

                numbers[j] = Integer.parseInt(cs[j]);
            }
            Double r = count(numbers);
            String as = r.toString();
            String result = "";
            if (as.replace("-", "").length()>=14){
                result = as.substring(0,14);
            }else {
                while (as.replace("-", "").length()<14){
                    as+='0';
                }
                result= as;
            }
            String outline = "Case #"+(i+1)+": " + result+"\n";
            System.out.print(outline);
            fw.write(outline);

        }
        fr.close();
        br.close();

        fw.close();
    }

    private static double count(int[] numbers) {
        int m = numbers.length-1;

        if (m==1){
            return numbers[1]/1d/numbers[0] -1;
        }
        if (m == 2){
            double b = (2*numbers[0]-numbers[1])/1d;
            double a = numbers[0]/1d;
            double c = (numbers[0]-numbers[1]-numbers[2])/1d;
            double x1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
            double x2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
            if (x1 >=-1 && x1 <=1){
                return x1;
            }else {
                return x2;
            }
        }
        return 3d;
    }
}
