package d1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_소가건너간이유1 {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(st.nextToken()) -1;
            int n2 = Integer.parseInt(st.nextToken());

            if(arr[n1] < 0) {
                arr[n1] = n2;
            }
            else if(arr[n1] != n2) {
                count ++;
                arr[n1] = n2;
            }

        }

        System.out.println(count);
    }
}
