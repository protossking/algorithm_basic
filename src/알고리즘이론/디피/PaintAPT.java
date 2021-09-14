package 알고리즘이론.디피;


/*
    아파트를 각 층별로 파란색 또는 노란색 페인트로 칠하되 다음고 ㅏ같은 규칙으로 칠하려고 한다.
    1. 노란색은 인접한 두 층에 연속해서 사용할수 있다.
    2. 파란색은 인접한 두 층에 연속해서 칠할수 없다. -> 이전층에 노란색ㅇㄴ 경우에만 파란색을 칠할 수 있다.
 */
public class PaintAPT {




    public static void main(String[] args) {
        int n = 8;
        int[] apt = new int[n+1];
        apt[0] = 1;
        apt[1] = 2;
        for(int i = 2; i <= n; i++) {
            apt[i] = apt[i-1] + apt[i-2];
        }

        System.out.printf("%d층 : %d가치 ", n, apt[n]);
    }
}
