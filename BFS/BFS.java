package samsung01;

import java.util.*;
/**
 * 
 *	1. BFS�� ť�� ���ۺκ� �ְ� �״��� ��
 *	2. �������� �� �� ���ڿ� �����ִ°� ���� ������ �� ����־�
 *  3. �״��� ��������ſ��� ������ �� ��
 *  2,3�ݺ�  
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

    //ť�� ����־��� ����
    public static void bfs(int cur) {
        Queue<Integer> q = new LinkedList<>();
        visited[cur] = true;
        
        q.add(cur);
        while (!q.isEmpty()) {
        	//���� ���� ������ remove�Ǵ°ž� �ֳ��ϸ� Queue�ݾ�!
            int here = q.remove();
            System.out.print(String.valueOf(here) + ' ');
            for (int there = 1; there <= n; there++) {
            	//�湮�� ���ߴµ� ������ �������� ������� �߰��ϴ°�
                if (visited[there] || (!edge[here][there])) continue;
                visited[there] = true;
                q.add(there);
            }
        }
    }
}
