package 알고리즘이론.디피;

public class Stick {

    public static void main(String[] args) {
        int n = 6;
        int[] stick = new int[n+1];
        stick[0] = 1;
        stick[1] = 2;

        for(int i = 2; i <= n; i++) {
            stick[i] = stick[i-1]*2 + stick[i-2];
            System.out.printf("%d 막대가 나올수 있는 경우의수 %d %n", i,stick[i]);
        }
    }
}
