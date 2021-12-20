package d1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_123더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[12];
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(in.readLine());

            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 4;

            for(int j = 3; j < n; j++) {
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            sb.append(arr[n-1]).append("\n");
        }
        System.out.println(sb.toString());


    }
}
