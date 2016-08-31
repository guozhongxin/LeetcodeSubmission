package LeetCode;

/**
 * Created by dell on 2016/8/7.
 */
public class HeapSort {

    public static void main(String[] args){
        int[] nums = new int[]{2,5,1,8,3,9,6,0,7,4};
        new HeapSort().heapSort(nums);
    }

    public void heapSort(int[] data){
        for (int i = 0; i<data.length; i++){
            createMaxHeap(data, data.length-1-i);
            swap(data, 0, data.length-1-i);
            print(data);
        }
    }

    private void swap(int[] data, int i, int j) {
        if (i==j){
            return;
        }
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void createMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex-1)>>>2; i>=0; i--){
            int k = i;
            while (2*k+1 <=lastIndex){
                int biggerSonIndex = 2*k+1;
                if (biggerSonIndex<lastIndex){
                    if (data[biggerSonIndex] < data[biggerSonIndex+1]){
                        biggerSonIndex ++;
                    }
                }
                if (data[biggerSonIndex] > data[k]){
                    swap(data, k, biggerSonIndex);
                    k = biggerSonIndex;
                }else {
                    break;
                }
            }
        }
    }

    void print(int[] nums){
        for (int i : nums) {
            System.out.print(i+"   ");
        }
        System.out.print('\n');
    }

}
