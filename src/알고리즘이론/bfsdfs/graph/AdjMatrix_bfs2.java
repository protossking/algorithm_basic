package 알고리즘이론.bfsdfs.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrix_bfs2 {
	
	private static boolean[][] map; // 인접행렬정보 boolean 은 가중치가 없는  
	private static boolean[] visited; // Node에 대한 방문 여부 
	private static int n; //Node 수 
	
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/lecture/AdjMatrix.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//1. 입력처리 
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(in.readLine()); // 전체 노드수 입력받기 
			//배열들을 생성 
			map = new boolean[n][n];
			visited = new boolean[n];
			
			//인접 행렬 정보 입력 받기
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						map[i][j] = true;
					}
					 
				}
			}
			
			bfs(0);
			System.out.println();
		}
		
	}
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<>(); // 탐색할 노드를 담을 큐 
		//1.  첫 방문한 node 를 queue에 담기 
		queue.offer(cur);
		//2. queue에 담은node를 방문 처리  큐에 넣을때 방문처리를 해야함 
		visited[cur] = true;
		
		//3. 탐색 시작 
		while(!queue.isEmpty()) { // queue 에 방문할 node를 담기 때문에 queue가 empty 라는것은 모든 노드를 다 방문 했다는 의미, empty가 아니면 계속 방문을 해야 한다.
			cur = queue.poll(); // 현재 방문할 노드를 queueu에서 꺼내 온다 .
			System.out.printf("%c ", cur + 65);
			
			//인접한 node를 방문 행이 노드  열이 인접된 노드 
			for(int adj = 0; adj <n; adj++) {
				//인접되어있고            방문하지 않았다면 
				if(map[cur][adj] == true && !visited[adj]) {
					//방문하기 위해 queue에 넣기 
					queue.offer(adj);
					visited[adj] = true; // 미리방문 했다고 표시하기 
				}
			}
			
		}
	}

}
