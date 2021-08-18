package 알고리즘이론.combination;

import java.util.Arrays;

public class Main {

    static int N;
    static int R;
    static int[] numbers;

    static int[] inputs;

    public static void main(String[] args) {
        N = 5;
        R = 3;
        numbers = new int[R];
        inputs = new int[]{1,2,3,4,5};
        combination(0, 0);
    }
    static void combination(int cnt, int start) {
        if(cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i = start; i < N; i++) {
            numbers[cnt] = inputs[i];
            combination(cnt + 1, i + 1);
        }
    }
}
