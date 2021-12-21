package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_공유기설치 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);

        int L = 0;
        int R = 1000000000;
        int ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if(determination(arr, mid, c)) {
                ans = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }
        System.out.println(ans);

    }

    static boolean determination(int[] arr, int c, int C) {
        int count = 0;
        int d = arr[0];
        count++;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - d < c) {
                continue;
            }
            d = arr[i];
            count ++;
        }
        if(count >= C) {
            return true;
        }
        else {
            return false;
        }
    }
}


/*
    가장 인접한 두 공유기의 사이의 거리를 최대로
    c개의 공유기를 설치했을떄 최대 인접거리는 얼마인가
    어떤 거리만큼은 거리를둘때 공유기 c 개를 설치할수 있는가.
 */