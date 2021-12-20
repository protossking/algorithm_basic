package d1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_수찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int m = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        Arrays.sort(arr);

        while (m -- > 0) {
            int target = Integer.parseInt(st.nextToken());

            if(binarySearch(arr, target)) {
                sb.append(1);
            }else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

    static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] == target) {
                return true;
            }
            else if(arr[mid] < target) {
                start = mid + 1;
            }
            else if(arr[mid] > target) {
                end = mid -1;
            }
        }
        return false;
    }




}
