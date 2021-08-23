package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_11399_ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int[] arr = new int[T];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i =0 ; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j <= i; j++) {
                sum = sum + arr[j];
            }
        }

        System.out.println(sum);

    }
}
