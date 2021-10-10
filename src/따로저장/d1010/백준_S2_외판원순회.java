package 따로저장.d1010;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S2_외판원순회 {

    // 핵심은 map 중에 안이어져있는길까지 더하니까 기저조건에서 이부분이 있으면 그냥 리턴시켜야함.
    static int[][] map;
    static boolean[] visited;
    static int[] arr;
    static int N;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        visited = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;

        perm(0);
        System.out.println(min);

    }

    static void perm(int depth) {
        if (depth == N) {
            // arr 의 sum
            for (int i = 0; i < arr.length - 1; i++) {
                if(map[arr[i]][arr[i + 1]] == 0) {
                    return;
                }
            }
            if(map[arr[N-1]][arr[0]] == 0) {
                return;
            }

            min = Math.min(min, sum(arr));
            return;
        }



        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            perm(depth + 1);
            visited[i] = false;

        }

    }

    static int sum(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(map[arr[i]][arr[i + 1]] == 0) {
                break;
            }else{
                sum += map[arr[i]][arr[i + 1]];
            }

        }
        if(map[arr[N-1]][arr[0]] == 0) {

        } else {
            sum += map[arr[N-1]][arr[0]];
        }

        return sum;
    }
}


/*
9 +
4123
1234 순열

순열인데 기저조건
if(depth == R)
    min = Math.min(min, ad)
    return;
if( sum > min )
    return;

    for(int i = 0; i < map.length; i ++)
        if(visited(i) continue;
        배열


        re 5 re 4 re 3 re 2 re 1

        하나의 배열을 통해서 순열 n 자리 뽑느다 .

 */