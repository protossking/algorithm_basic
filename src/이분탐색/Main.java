package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }







    }

    static boolean deter (int[] arr, int mid, int c) {
        int count = 0;
        int d = arr[0];

        count ++;
        for(int i = 1; i < arr.length; i++) {

            if(arr[i] - d < mid) continue;
            d = arr[i];
            count ++;
        }
        if(count >= c) {
            return true;
        }
        else {
            return false;
        }
    }









}
