package utils;

import java.io.*;
import java.util.Scanner;

/**
 * Created by v-zhoguo on 7/10/2016.
 */
public class Input {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        String path = "C:\\Users\\v-zhoguo\\Desktop\\test.txt";
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();


        String outPath = "C:\\Users\\v-zhoguo\\Desktop\\out.txt";
        File outFile = new File(outPath);
        FileWriter fw = new FileWriter(outFile);



        int lineNumber = 1;
        while (line !=null){
            String outLine = (lineNumber++) + ":  \t"+line + "\n";
            System.out.print(outLine);
            fw.write(outLine);
            line = br.readLine();
        }

        fr.close();
        br.close();

        fw.close();

    }
}
