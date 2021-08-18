package 알고리즘이론.combination;

public class Swea9229_한빈이1 {
}


/*
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int[] snacks;
    static int[] selected;
    static int answer;
    static int M;
    private static void dfs(int cnt, int s) {
        if(cnt == 2) {
            int sum = Arrays.stream(selected).sum();
            if(sum > M) return;
            answer = answer > sum ? answer : sum;
            return;
        }

        for(int i = s; i < snacks.length; i++) {
            selected[cnt] = snacks[i];
            dfs(cnt+1, i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            M = sc.nextInt();
            snacks = new int[N];
            selected = new int[2];
            answer = -1;
            for(int i = 0; i< N; i++)
                snacks[i] = sc.nextInt();
            dfs(0, 0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
 */