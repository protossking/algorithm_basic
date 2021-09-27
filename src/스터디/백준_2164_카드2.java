package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_2164_카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
//        System.out.println(q);

        while (q.size() > 1) {
            q.poll();
            int num = q.poll();
            q.add(num);


        }
        System.out.println(q.poll());

    }
}
