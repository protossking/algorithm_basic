package 따로저장.d1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class 백준_요세푸스문제 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            queue.offer(i+1);
        }
//        System.out.println(queue);



        int count = 0;
        sb.append("<");
        while (true) {
            count++;
            if(queue.size()< 2) {
                break;
            }
            if(count == K) {
                int lNum = queue.poll();

                list.add(lNum);
                count = 0;
                continue;
            }
            int num = queue.poll();
            queue.offer(num);
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }


        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size()-1) {
                sb.append(", ");
            }

        }
        sb.append(">");
        System.out.println(sb.toString());


    }
}
