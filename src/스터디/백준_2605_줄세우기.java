package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2605_줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());



        int[] ans = new int[T];
        ArrayList<Integer> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        a.add(-1);
        for(int i = 1; i <= T ;i++) {
            int index = Integer.parseInt(st.nextToken());
            a.add(i-index, i);
        }
        for(int i = 1; i < a.size(); i++) {
            System.out.print(a.get(i)+ " ");
        }


    }
}
