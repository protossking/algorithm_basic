package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_나무자르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long L = 0;
        long R = 2000000000;
        long ans = 0;

        while (L <= R) {
            int mid = (int) (L+R) / 2;
            if(determination(mid, a, M)) {
                ans = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }
        System.out.println(ans);

    }




    static boolean determination(int H, int[] a, int M) {
        long sum = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] > H) {
                sum += a[i] - H;
            }
        }
        if(sum >= M) {
            return true;
        }
        else {
            return false;
        }
    }
}




// 설정할수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

/*
        조건                  타겟
    원하는 길이 m 만큼 있느 ㄴ최대 높이는 얼마인가

    어떤 높이로 잘랐을떄 원하는길이 m 만큼 얻을수 있는가


    h 정해서 결정문제 풀기 o (n)
    o(logx)번
 */