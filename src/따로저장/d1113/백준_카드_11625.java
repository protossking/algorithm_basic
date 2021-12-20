package 따로저장.d1113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_카드_11625 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        long[] arr = new long[n];


        for(int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(in.readLine());

        }
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int curCount = 0;
        long ansNumber = 0;
        int ansCount = 0;

        curCount = 1;
        ansNumber = arr[0];
        ansCount = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                curCount++;
            } else {
                curCount = 1;
            }

            if(curCount > ansCount) {
                ansCount = curCount;
                ansNumber = arr[i];
            }

        }
        System.out.println(ansNumber);







    }
}
