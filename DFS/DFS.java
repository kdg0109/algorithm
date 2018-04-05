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
        System.out.println("edge�� ���� : [" + (n+1) + "][" + (n + 1) + "]");
        edge = new boolean[n + 1][n + 1];
        System.out.println("visited�� ���� : [" + (n+1) + "]");
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edge[u][v] = true;
        }
        for(int row = 0; row < edge[0].length; row++){		//�� ����.
	        for(int j = 0; j < edge.length ; j++){			//�� �� ���� �״��� ������ �Ѿ�� �ǵ���
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
        	//�湮�߰ų� ������ �ȵ����� �� �ѱ�°���
        	//1�� �������� �� ���캸�°ž� ������ֳ��ȵ��ֳ� ���� ����������� �ű�� ���°���
        	//2�� ����Ǿ������ϱ� 2�� ���� �� ����� �̹� �湮�Ѱ��� �ƴ� ������ ���ִ°��� ����ǰų� �湮�ѰŸ� �� �ٽ� ������
        	//�׷��� ���� ���ٰ� �̹� �湮�ѰŰ� �׸��� ������ ���־�׷� �ٽ� �� ����~~�����°�
            if (visited[i] || !edge[cur][i]){
            	continue; // already visited or not connected.
            }
            dfs(i);
        }
    }
}