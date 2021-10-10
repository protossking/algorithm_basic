package 따로저장.d1010;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S4_요세푸스 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < N; i++) {
            queue.offer(i+1);
        }
        int count = 0;

        while(count < N) {
            count ++;

            for(int i = 0; i < K-1; i++) {
                int num = queue.poll();
                queue.offer(num);
            }
            int ans = queue.poll();
            if(count == N) {
                sb.append(ans);
            } else {
                sb.append(ans).append(",").append(" ");
            }


        }
        sb.append(">");
        System.out.println(sb.toString());

    }
}


/*
1 2 3 4 5 6 7   3
4 5 6 7 1 2   6
7 1 2 4 5  2
4 5 7 1   7
1 4 5    5



k 번째 -1 까지 poll 하고 offer




1 2 3 4 5 6 7

3
6
2
5



 */