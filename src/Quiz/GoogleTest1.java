package Quiz;

import java.io.*;

/**
 * Created by zhongxin on 7/10/2016.
 */
public class GoogleTest1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\v-zhoguo\\Desktop\\A-large.in";
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int caseNumber = Integer.parseInt(br.readLine());

        String outPath = "C:\\Users\\v-zhoguo\\Desktop\\out.txt";
        File outFile = new File(outPath);
        FileWriter fw = new FileWriter(outFile);

        for (int i =0; i< caseNumber;i++){
            int personNumber = Integer.parseInt(br.readLine());
            String[] persons = new String[personNumber];
            for (int j =0; j< personNumber; j++){
                persons[j] = br.readLine();
            }
            String outline = "Case #"+(i+1)+": " + election(persons)+"\n";
            System.out.print(outline);
            fw.write(outline);
        }

        fr.close();
        br.close();

        fw.close();

    }

    private static String election(String[] persons) {
        int max = 0;
        String leader = persons[0];
        for (int j =0; j < persons.length;j++){
            String name = persons[j];
            int[] letters = new int[28];
            int nameletter =0;
            int nameLength = name.length();

            for (int i =0; i<nameLength; i++){
                char l = name.charAt(i);
                if (l!=' '){
                    letters[l-'A'] =1;
                }
            }
            for(int i =0; i< 28; i++){
                nameletter+=letters[i];
            }
            if (nameletter> max){
                max = nameletter;
                leader = name;
            }else if (nameletter == max){
                int length = 20;
                for (int i =0; i<length; i++){
                    if (name.charAt(i)> leader.charAt(i)){
                        break;
                    }else if (name.charAt(i) < leader.charAt(i)){
                        max = nameletter;
                        leader = name;
                        break;
                    }
                }
            }
        }
        return leader;


    }
}
