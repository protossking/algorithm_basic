package d1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 백준_수정렬하기2 {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        Integer[] arr = new Integer[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

//        Arrays.sort(arr, Collections.reverseOrder());

       Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        for(int n : arr) {
            sb.append(n).append("\n");
        }
        System.out.println(sb.toString());

    }
}
