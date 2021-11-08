package 따로저장.d1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_나는야포켓몬 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String p = in.readLine();
            String n = Integer.toString(i + 1);
            map.put(p, n);
            map.put(n, p);

        }
//        System.out.println(map);

        for(int i = 0; i < M; i++) {
            System.out.println(map.get(in.readLine()));
        }


    }
}
