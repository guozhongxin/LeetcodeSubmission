package Quiz;

import javax.swing.text.html.MinimalHTMLWriter;
import java.io.*;

/**
 * Created by zhongxin on 7/10/2016.
 */
public class GoogleTest2 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\v-zhoguo\\Desktop\\test.txt";
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int caseNumber = Integer.parseInt(br.readLine());

        String outPath = "C:\\Users\\v-zhoguo\\Desktop\\out.txt";
        File outFile = new File(outPath);
        FileWriter fw = new FileWriter(outFile);

        for(int i = 0 ; i < caseNumber; i++){
            String[] rcline = br.readLine().split(" ");

            int r = Integer.parseInt(rcline[0]);
            int c = Integer.parseInt(rcline[1]);
            int[][] hight = new int[r][c];

            for (int j = 0; j< r ; j++){
                String[] h = br.readLine().split(" ");

                for (int p = 0; p< c ; p++){
                    hight[j][p] = Integer.parseInt(h[p]) ;
                }
            }
            int water = count_1(hight,r,c);
            String outline = "Case #"+(i+1)+": " +  water+"\n";
            System.out.print(outline);
            fw.write(outline);
        }

        fr.close();
        br.close();

        fw.close();


    }

    private static int count_1(int[][] hight, int r, int c) {
        int maxheight = 0;
        for (int j = 0; j< r ; j++){
            int sum = 0;
            for (int p = 0; p< c ; p++){
                sum += hight[j][p];
            }
            if (sum>maxheight){
                maxheight = sum;
            }
        }

        int[][] watercells = new int[r][c];
        int water_sum = 0;
        for (int i = 1; i<r-1; r++){
            for (int j =1; j< c-1 ; j++){
                watercells[i][j] = maxheight - hight[i][j];
            }
        }
        boolean hasChange = true;
        while (hasChange){
            hasChange = false;
            for (int i = 1; i<r-1; r++){
                for (int j =1; j< c-1 ; j++){
                    int current_hight_up = hight[r-1][c] + watercells[r-1][c];
                    int current_hight_down = hight[r+1][c] + watercells[r+1][c];
                    int current_hight_left = hight[r][c-1] + watercells[r][c-1];
                    int current_hight_right = hight[r][c+1] + watercells[r][c+1];
                    int current_hight = hight[r][c]+ watercells[r][c];
                    int min_arround_current_hight = Math.min(Math.min(current_hight_down, current_hight_left), Math.min(current_hight_right, current_hight_up));
                    if (hight[i][j] < min_arround_current_hight){
                        if (current_hight > min_arround_current_hight){
                            watercells[i][j] = min_arround_current_hight - hight[i][j];
                            hasChange = true;
                        }
                    }else if (watercells[i][j] > 0){
                        watercells[i][j] = 0;
                        hasChange = false;
                    }
                }
            }
        }
        for (int i = 1; i<r-1; r++){
            for (int j =1; j< c-1 ; j++){
                water_sum +=watercells[i][j];
            }
        }
        return water_sum;
    }

    private static int count(int[][] hight, int rows, int columns) {
        if (rows<=2 || columns <= 2){
            return 0;
        }
        int[][] watercells = new int[rows][columns];
        int water_sum = 0;
        for (int r = 1; r < rows-1; r++){
            for (int c =1; c< columns-1; c++){
                dropwatertocell(hight, watercells, r, c, 't');
            }
        }

        for (int r = 1; r < rows-1; r++){
            for (int c =1; c< columns-1; c++){
                water_sum+=watercells[r][c];
            }
        }
        return water_sum;
    }

    private static void dropwatertocell(int[][] hight, int[][] watercells, int r, int c, char from) {
        if (r<=0 || r >=hight.length-1)
            return;
        if (c<=0 || c>= hight[0].length-1)
            return;
        System.out.println(r+" "+c + ": "+ watercells[r][c]);
        int current_hight_up = hight[r-1][c] + watercells[r-1][c];
        int current_hight_down = hight[r+1][c] + watercells[r+1][c];
        int current_hight_left = hight[r][c-1] + watercells[r][c-1];
        int current_hight_right = hight[r][c+1] + watercells[r][c+1];
        int current_hight = hight[r][c]+ watercells[r][c];
        int min_arround_current_hight = Math.min(Math.min(current_hight_down, current_hight_left), Math.min(current_hight_right, current_hight_up));
        if (current_hight< min_arround_current_hight){
            watercells[r][c] +=1;
            dropwatertocell(hight, watercells, r, c, from);
        }
        else if( current_hight_left == min_arround_current_hight ){
            if (from == 'l'){
                watercells[r][c] +=1;
                dropwatertocell(hight, watercells, r, c, from);
            }else {
                dropwatertocell(hight, watercells, r, c - 1, 'r');
            }
        }else if(current_hight_up  == min_arround_current_hight) {
            if (from == 'u'){
                watercells[r][c] +=1;
                dropwatertocell(hight, watercells, r, c, from);
            }else {
                dropwatertocell(hight, watercells, r - 1, c, 'd');
            }
        }else if(current_hight_right  == min_arround_current_hight){
            if (from == 'r'){
                watercells[r][c] +=1;
                dropwatertocell(hight, watercells, r, c, from);
            }else {
                dropwatertocell(hight, watercells, r, c + 1, 'l');
            }
        }else if(current_hight_down  == min_arround_current_hight){
            if (from == 'd'){
                watercells[r][c] +=1;
                dropwatertocell(hight, watercells, r, c, from);
            }else {
                dropwatertocell(hight, watercells, r + 1, c, 'u');
            }
        }
    }

    
}
