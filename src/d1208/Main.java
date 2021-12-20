package d1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.DoubleStream;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        int[] a = new int[N];
        for(int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(in.readLine());

        int[] b = new int[m];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < b.length; i++) {

            b[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        Arrays.sort(a);

        for(int i = 0; i < b.length; i++) {
            if(binarySearch(a, b[i])) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println(1%5);

    }

    static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) {
                return true;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else if(arr[mid] > target) {
                end = mid - 1;
            }
        }
        return false;
    }
}
