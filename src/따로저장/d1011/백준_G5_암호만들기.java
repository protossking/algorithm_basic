package 따로저장.d1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_G5_암호만들기 {

    static int L;
    static int C;
    static char[] al;
    static boolean[] visited;
    static char[] ans;
    static int count;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        al = new char[C];
        ans = new char[L];
        count = 0;
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < C; i++) {
            al[i] = st.nextToken().charAt(0);
        }
        combi(0,0);


        Collections.sort(list);
        System.out.println(list);

    }
    static void combi(int depth, int start) {
        if(depth == L) {
            String a = "";
            for(char i: ans) {
                System.out.print(i);
                a += i;
            }
            list.add(a);

            System.out.println("");
            return;
        }

        for(int i = start; i < C; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            ans[depth] = al[i];
            combi(depth + 1, i+1);
            visited[i] = false;

        }
    }
}


/*
6개중에 4개인데 알파벳순서대로
 */