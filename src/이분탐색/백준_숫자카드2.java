package 이분탐색;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_숫자카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(in.readLine());
        int[] arr2 = new int[M];

        st = new StringTokenizer(in.readLine());





        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr2.length; i++) {
            int key = Integer.parseInt(st.nextToken());
            int low = lower_bound(arr, 0, arr.length-1, key);
            int up = upper_bound(arr, 0, arr.length-1, key);
            sb.append(up - low).append(" ");

        }
        System.out.println(sb.toString());


    }

    static int lower_bound(int[] arr, int L, int R, int target) {
        int ans = R + 1;

        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] >= target) {
                ans = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static int upper_bound(int[] arr, int L, int R, int target) {
        int ans= R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] > target) {
                ans = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return ans;
    }
}
