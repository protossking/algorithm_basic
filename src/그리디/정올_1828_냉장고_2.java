package 그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 정올_1828_냉장고_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int count = 1;
        int max = arr[0][1];

        for(int i = 1; i < N; i++) {
            if(max < arr[i][0]) {
                max = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
