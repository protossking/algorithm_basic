package 알고리즘이론.디피;

public class DP2_FIBo {

    private static long fino1 ( int n) {
        long[] D = new long[n+1];
        D[0] = 0;
        D[1] = 1;

        for(int i = 2; i<= n; i++) {
            D[i] = D[i-1] + D[i-2];
        }
        return D[n];
    }
}
