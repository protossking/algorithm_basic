package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_겹치는건싫어 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int right = -1;
        int sum = 0;
        for(int left = 0; left < n; left ++) {

        }

    }
}
