package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_S3_프린터큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        List<Integer> list;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken()); // f
            int M = Integer.parseInt(st.nextToken()); // findindex

            list = new ArrayList<>();


            Queue<int[]> queue = new LinkedList<>();
            int index = 0;
            st = new StringTokenizer(in.readLine());


            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken());
                if (a > max) {
                    max = a;  // 초기 max 값
                }
                list.add(a);
                queue.offer(new int[]{a, index++});
            }



//            System.out.println(max);
            Collections.sort(list, Collections.reverseOrder());;
            int count = 0;
            int k = 0;
            while (!queue.isEmpty()) {
                int cur[] = queue.poll();

                if(cur[0] == list.get(k)) { // 우선순위 가장 큰ㄱ ㅓ 찾았을때
                    count++;
                    //max 재설정
                    k++;

                    if(cur[1] == M) {

                        break;
                    }
                }
                else { //큰 수가 아닐때
                    queue.offer(new int[]{cur[0], cur[1]});
                }

            }
            sb.append(count).append("\n");


        }

        System.out.println(sb.toString());

    }
}


/*

값, 위치

맥스값 찾고

맥스값 나올때까지 빼고 넣고

뺄때 그 초기위치랑 같으면 답
아니면 count ++


반복











 */