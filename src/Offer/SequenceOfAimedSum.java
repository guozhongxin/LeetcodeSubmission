package Offer;

/**
 *
 * Q41
 * Created by dell on 2016/6/26.
 */
public class SequenceOfAimedSum {
    public static void main(String[] args){
        findContinousSequence(100);
    }

    public static void findContinousSequence_1(int s){
        int start =1, end =2, sum=3;
        int biggest = (s+1)>>1;
        while (start<biggest){
            while(sum<s && end <= biggest){
                end++;
                sum+=end;
            }
            while(sum>s && start < biggest){
                sum -= start;
                start++;
            }
            if (sum==s){
                printSequence(start, end);
                end++;
                sum+=end;
            }
        }
    }

    public static void findContinousSequence(int s){
        int start =1, end =2, sum=3;
        int biggest = (s+1)>>1;
        while (start<end && start<biggest){

            while(sum>s && start < biggest){
                sum -= start;
                start++;
            }
            if (sum==s){
                printSequence(start, end);
            }

            end++;
            sum+=end;
        }
    }

    public static void printSequence(int start, int end){
        for (int i = start; i<=end; i++){
            System.out.print(i+" ");
        }
        System.out.print('\n');
    }
}
