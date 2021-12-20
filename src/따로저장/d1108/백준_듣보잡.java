package 따로저장.d1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // set > map ;

        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < N; i++) {

            set.add(in.readLine());

        }
        for(int i = 0; i < M; i++) {
            String b = in.readLine();
            if(set.contains(b)){
                list.add(b);
            }



        }

        System.out.println(list.size());
        Collections.sort(list);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
