package 알고리즘이론.순열;

import java.util.Arrays;

public class 순열_비트마스킹 {

    static int N = 3, R = 2;
    static int[] input;
    static int[] numbers;


    public static void main(String[] args) {
        input = new int[]{1,4,7};
        numbers = new int[R];


        permutation(0, 0);
    }
    static void permutation(int cnt, int flag) {
        if(cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i = 0; i < N; i++) {
            if((flag & 1 << i) != 0) continue; // 0이 아니면 1로 되어있다는 뜻 사용중이라는 뜻
            numbers[cnt] = input[i];

            permutation(cnt+1, flag | 1 << i); // 이게 isSelected[i] = true  // flag 자체 변수를 바꾼것이 아니라 되돌릴 필요가 없어서 isSelected[i] = cnt 같은거 안해도 됨
        }
    }
}
