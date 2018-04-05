package samsung01;

import java.util.*;
/**
 * 
 *	1. BFS는 큐임 시작부분 넣고 그다음 빼
 *	2. 뺀다음에 그 뺀 숫자와 관련있는거 작은 순으로 다 집어넣어
 *  3. 그다음 집어넣은거에서 작은거 또 빼
 *  2,3반복  
 *
 */
public class BFS {
    static boolean edge[][];
    static boolean visited[];
    static int n;
    static int m;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        edge = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edge[u][v] = true;
        }
        bfs(1);
    }

    //큐를 집어넣었음 ㅋㅋ
    public static void bfs(int cur) {
        Queue<Integer> q = new LinkedList<>();
        visited[cur] = true;
        
        q.add(cur);
        while (!q.isEmpty()) {
        	//가장 먼저 넣은게 remove되는거야 왜냐하면 Queue잖아!
            int here = q.remove();
            System.out.print(String.valueOf(here) + ' ');
            for (int there = 1; there <= n; there++) {
            	//방문은 안했는데 연결이 되있으면 순서대로 추가하는겨
                if (visited[there] || (!edge[here][there])) continue;
                visited[there] = true;
                q.add(there);
            }
        }
    }
}
