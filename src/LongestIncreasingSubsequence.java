import java.util.Arrays;

public class LongestIncreasingSubsequence {

    static int[] arr;
    static int[] temp;


    public static void lis(int i, int j) {
        if (j == arr.length) {
            return;
        }

        if (i == j) {
            lis(0, j+1);
        } else if (arr[i] <= arr[j]) {
            temp[j]++;
            lis(i+1, j);
        } else if (arr[i] > arr[j]) {

        lis(i+1, j);
    }

    }
    public static void main(String[] args) {
        arr=new int[]{10,4,30,1,1};
        temp=new int[arr.length];
        Arrays.fill(temp,1);

        lis(0,1);

        Arrays.sort(temp);
        System.out.println(temp[temp.length-1]);
    }



}
