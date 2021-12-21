package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_배열합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] b = new int[m];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        for(int i = 0; i < b.length; i++) {
            list.add(b[i]);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());




    }
}
