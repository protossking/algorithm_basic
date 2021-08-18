package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea1974_스토쿠검증 {



    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int T;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        T = Integer.parseInt(input.readLine());

        // 언제나 배열은 동일하다.
        map = new int[9][9];

        for (int t = 1; t <= T; t++) {

            for (int r = 0; r < 9; r++) {
                tokens = new StringTokenizer(input.readLine());
                for (int c = 0; c < 9; c++) {
                    map[r][c] = Integer.parseInt(tokens.nextToken());
                }
            }

			/*for(int [] row: map) {
				System.out.println(Arrays.toString(row));
			}*/
            // 입력 완료
            int answer = 0;
            // 가로, 세로, 작은 사각형에서 중복된 값이 없는지?
            //System.out.println(checkLine());
            //System.out.println(checkSquare());

            if (checkLine() && checkSquareBitmasking(0, 0)) {
                answer = 1;
            }
            output.append(String.format("#%d %d%n", t, answer));

        }
        System.out.println(output);
    }

    private static boolean checkLine() {
        boolean[] visited = new boolean[10]; // 1 ~ 9까지의 상태 저장.
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            // 가로로 먼저 찾아보기.
            for (int c = 0; c < 9; c++) {
                // 중복된 경우 - 탐색 실패.
                if (visited[map[i][c]]) {
                    return false;
                }
                // 그렇지 않으면 흔적 남기기.
                else {
                    visited[map[i][c]] = true;
                }
            }
            // 세로로 찾아보기
            Arrays.fill(visited, false); // 배열 초기화
            for (int r = 0; r < 9; r++) {
                if (visited[map[r][i]]) {
                    return false;
                } else {
                    visited[map[r][i]] = true;
                }
            }
        }
        // 정상!!!
        return true;
    }

    private static boolean checkSquareBitmasking() {
        //boolean[] visited = new boolean[10]; // 1 ~ 9까지의 상태 저장.
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                //Arrays.fill(visited, false);
                int status = 0; // 상태값을 가지고 있을 변수 하나면 충분 = 32개의 bit 뿐이에요..
                for (int r2 = r; r2 < r + 3; r2++) {
                    for (int c2 = c; c2 < c + 3; c2++) {
                        if ((status & 1 << map[r2][c2]) > 0) { // status에서도 동일 bit에 1을 발견 했다!!!
                            return false;
                        } else {
                            status |= 1 << map[r2][c2]; // 비트에 map[r2][c2]의 상태 추가해주기.
                        }

						/*if (visited[map[r2][c2]]) {
							return false;
						} else {
							visited[map[r2][c2]] = true;
						}*/
                    }
                }
            }
        }
        return true;
    }

    // 재귀 형태로 구현해보기.
    // 1. 도대체 뭐하는 메서드입니까?  출발점을 입력 받아서 가로로 3, 세로로 3의 영역을 확인한다.
    private static boolean checkSquareBitmasking(int r, int c) {
        // 3. 기저조건 처리
        if(c >6) {
            return checkSquareBitmasking(r+3, 0);
        }
        // 맨 마지막 행을 넘어갔다는 이야기는 이제까지 다 성공했다는.....
        if(r>6) {
            return true;
        }
        // 2. 할일을 처리하고 재귀로 자신을 호출한다.
        int status = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if ((status & 1 << map[i][j]) > 0) {
                    return false;
                } else {
                    status |= 1 << map[i][j];
                }
            }
        }
        return checkSquareBitmasking(r, c + 3);
    }

    private static boolean checkSquare() {
        boolean[] visited = new boolean[10]; // 1 ~ 9까지의 상태 저장.
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                Arrays.fill(visited, false);
                for (int r2 = r; r2 < r + 3; r2++) {
                    for (int c2 = c; c2 < c + 3; c2++) {

                        if (visited[map[r2][c2]]) {
                            return false;
                        } else {
                            visited[map[r2][c2]] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static String src = "10\r\n" +
            "7 3 6 4 2 9 5 8 1\r\n" +
            "5 8 9 1 6 7 3 2 4\r\n" +
            "2 1 4 5 8 3 6 9 7\r\n" +
            "8 4 7 9 3 6 1 5 2\r\n" +
            "1 5 3 8 4 2 9 7 6\r\n" +
            "9 6 2 7 5 1 8 4 3\r\n" +
            "4 2 1 3 9 8 7 6 5\r\n" +
            "3 9 5 6 7 4 2 1 8\r\n" +
            "6 7 8 2 1 5 4 3 9\r\n" +
            "7 3 6 4 8 9 2 5 1\r\n" +
            "8 5 2 7 3 1 6 9 4\r\n" +
            "9 1 4 5 6 2 7 3 8\r\n" +
            "4 9 7 2 5 6 8 1 3\r\n" +
            "5 6 3 1 8 7 9 4 2\r\n" +
            "2 8 1 9 4 3 5 6 7\r\n" +
            "6 7 5 3 2 4 1 8 9\r\n" +
            "1 4 9 6 7 8 3 2 5\r\n" +
            "3 2 8 1 9 5 4 7 6\r\n" +
            "2 4 6 7 5 3 1 9 8\r\n" +
            "7 5 8 1 9 4 2 3 6\r\n" +
            "3 9 1 2 6 8 7 5 4\r\n" +
            "5 8 2 3 4 6 9 7 1\r\n" +
            "1 6 3 9 7 2 4 8 5\r\n" +
            "9 7 4 8 1 5 6 2 3\r\n" +
            "4 2 7 5 8 1 3 6 9\r\n" +
            "6 3 5 4 2 9 8 1 7\r\n" +
            "8 1 9 6 3 7 5 4 2\r\n" +
            "8 4 5 2 9 6 1 3 7\r\n" +
            "1 3 6 7 5 8 4 9 2\r\n" +
            "9 7 2 1 3 4 6 5 8\r\n" +
            "2 9 7 4 6 3 8 5 1\r\n" +
            "4 6 1 5 8 2 9 7 3\r\n" +
            "5 8 3 9 7 1 2 4 6\r\n" +
            "3 2 8 6 4 5 7 1 9\r\n" +
            "7 1 4 3 2 9 6 8 5\r\n" +
            "6 5 9 8 1 7 3 2 4\r\n" +
            "4 5 7 1 6 3 8 2 9\r\n" +
            "6 3 9 8 2 7 5 4 1\r\n" +
            "7 9 3 4 8 5 1 6 2\r\n" +
            "1 8 2 5 4 9 6 3 7\r\n" +
            "8 6 1 7 9 2 3 5 4\r\n" +
            "5 2 4 6 3 1 7 9 8\r\n" +
            "3 7 6 9 1 4 2 8 5\r\n" +
            "2 4 5 3 7 8 9 1 6\r\n" +
            "9 1 8 2 5 6 4 7 3\r\n" +
            "1 5 2 3 8 6 9 4 7\r\n" +
            "4 8 3 2 7 9 1 5 6\r\n" +
            "7 6 9 1 5 4 8 2 3\r\n" +
            "2 1 8 6 4 7 5 3 9\r\n" +
            "6 9 7 5 3 8 2 1 4\r\n" +
            "5 3 4 9 1 2 6 7 8\r\n" +
            "9 7 1 4 6 5 3 8 2\r\n" +
            "8 2 5 7 9 3 4 6 1\r\n" +
            "3 4 6 8 2 1 7 9 5\r\n" +
            "1 5 8 6 7 2 3 4 9\r\n" +
            "7 2 9 3 4 8 5 1 6\r\n" +
            "6 3 4 5 1 9 7 2 8\r\n" +
            "8 9 2 1 2 5 6 7 4\r\n" +
            "3 7 6 8 9 4 2 5 1\r\n" +
            "5 4 1 7 3 6 8 9 3\r\n" +
            "2 8 7 9 6 1 4 3 5\r\n" +
            "4 1 5 2 8 3 9 6 7\r\n" +
            "9 6 3 4 5 7 1 8 2\r\n" +
            "1 2 4 9 3 6 7 8 5\r\n" +
            "7 8 6 2 4 5 3 9 1\r\n" +
            "3 9 5 1 7 8 2 4 6\r\n" +
            "5 1 9 4 6 2 8 7 3\r\n" +
            "4 6 7 8 9 3 5 1 2\r\n" +
            "8 3 2 5 1 7 9 6 4\r\n" +
            "9 7 3 6 5 4 1 2 8\r\n" +
            "6 5 8 7 2 1 4 3 9\r\n" +
            "2 4 1 3 8 9 6 5 7\r\n" +
            "5 9 3 8 4 1 7 6 2\r\n" +
            "2 1 8 7 6 3 4 9 5\r\n" +
            "7 6 4 9 2 5 1 3 8\r\n" +
            "4 3 6 5 9 2 8 1 7\r\n" +
            "1 8 5 4 3 7 9 2 6\r\n" +
            "9 2 7 1 8 6 5 4 3\r\n" +
            "3 4 1 6 5 8 2 7 9\r\n" +
            "6 5 9 2 7 4 3 8 1\r\n" +
            "8 7 2 3 1 9 6 5 4\r\n" +
            "7 1 4 5 8 9 2 3 6\r\n" +
            "8 5 2 3 6 4 7 1 9\r\n" +
            "3 6 9 1 7 2 8 5 4\r\n" +
            "2 3 1 9 4 6 5 7 8\r\n" +
            "6 8 5 7 3 2 9 4 1\r\n" +
            "9 4 7 8 1 5 3 6 2\r\n" +
            "1 7 8 6 9 3 4 2 5\r\n" +
            "4 2 3 1 5 8 6 9 7\r\n" +
            "5 9 6 4 2 7 1 8 3\r\n" +
            "";
}
