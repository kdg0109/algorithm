package samsung01;

import java.util.*;

public class DFS {
    static boolean edge[][];
    static boolean visited[];
    static int n;
    static int m;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println();
        System.out.println("edge의 선언 : [" + (n+1) + "][" + (n + 1) + "]");
        edge = new boolean[n + 1][n + 1];
        System.out.println("visited의 선언 : [" + (n+1) + "]");
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edge[u][v] = true;
        }
        for(int row = 0; row < edge[0].length; row++){		//행 돈다.
	        for(int j = 0; j < edge.length ; j++){			//열 쭉 돈다 그다음 행으로 넘어가고 또돌고
	        	System.out.print(edge[row][j]);

	        	System.out.print("\t");
	        }

        	System.out.println("\n");
        }
        dfs(1);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(String.valueOf(cur) + ' ');
        for (int i = 1; i <= n; i++) {
        	//방문했거나 연결이 안되있을 때 넘기는거임
        	//1을 시작으로 쭉 살펴보는거야 연결되있나안되있나 만약 연결되있으면 거기로 들어가는거임
        	//2가 연결되어있으니까 2로 들어가서 또 살펴봐 이미 방문한건지 아님 연결이 되있는건지 연결되거나 방문한거면 또 다시 돌겠지
        	//그렇게 쭉쭉 가다가 이미 방문한거고 그리고 연결이 되있어그럼 다시 빽 빽빽~~나가는거
            if (visited[i] || !edge[cur][i]){
            	continue; // already visited or not connected.
            }
            dfs(i);
        }
    }
}