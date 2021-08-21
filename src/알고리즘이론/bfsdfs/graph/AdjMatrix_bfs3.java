package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrix_bfs3 {
	
	private static int[][] map; // 인접행렬정보 
	private static boolean[][] visited; // Node에 대한 방문 여부 
	private static int n; //Node 수 
	
//								상 하 좌 우 
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int sr, sc, er, ec;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("res/lecture/AdjMatrix.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//1. 입력처리 
//		int T = Integer.parseInt(in.readLine());
		
//		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(in.readLine()); // 전체 노드수 입력받기 
			//배열들을 생성 
			map = new int[n][n];
			visited = new boolean[n][n];
			
			//인접 행렬 정보 입력 받기
//			for(int i = 0; i < n; i++) {
//				StringTokenizer st = new StringTokenizer(in.readLine());
//				for(int j = 0; j < n; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			bfs();
			System.out.println();
//		}
		
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>(); // 탐색할 노드를 담을 큐 
		//1.  첫 방문한 node 를 queue에 담기 
		queue.offer(new int[] {sr,sc});
		//2. queue에 담은node를 방문 처리  큐에 넣을때 방문처리를 해야함  // 들어갈떄 방문처리
		visited[sr][sc] = true;
		
		//3. 탐색 시작 
		top:
		while(!queue.isEmpty()) { // queue 에 방문할 node를 담기 때문에 queue가 empty 라는것은 모든 노드를 다 방문 했다는 의미, empty가 아니면 계속 방문을 해야 한다.
			int[] cur = queue.poll(); // 현재 방문할 노드를 queueu에서 꺼내 온다 .
			int r = cur[0];
			int c = cur[1];
			
			
			//인접한 node를 방문 행이 노드  열이 인접된 노드  
			for(int i = 0; i < 4; i++) { // 상하좌우 네번 반복 
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				//경계검사 && 인접한 node가 도착 위치 확인 
				if(nr > -1 && nr < n && nc > -1 && nc <n && !visited[nr][nc]) {
					//인접 노드가 도착위치인지 확인 
					if(nr == er && nc == ec) {
						System.out.printf("%d %d도착했다 ~~\n",nr, nc);
						break top;
					}else { // 인접 노드가 도착위치가 아니라면 
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
			
		}
	}

}
