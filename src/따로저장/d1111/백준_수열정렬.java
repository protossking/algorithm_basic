package 따로저장.d1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_수열정렬 {

    static class Su implements Comparable<Su> {
        int idx;
        int num;

        public Su(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Su o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st  = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        Su[] A = new Su[N];
        int[] p = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = new Su(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(A);

        for(int i = 0; i < N; i++) {
            p[A[i].idx] = i;
        }
        for(int n : p) {
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());


    }
}
