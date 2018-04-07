package samsung01;

import java.util.Scanner;

public class samsung02 {
	static int t = 0; 			//�׽�Ʈ ���̽�
	static int m = 0; 			//���߹� ���� ����
	static int n = 0;			//���߹� ���� ����
	static int k = 0;			//���߸� ���� ����
	static int x, y = 0;		//���� ��ǥ XY
	static int map[][] = null;	//���� ��
	static boolean visited[][] = null;	//�湮 ���� 
	static int cnt = 0;			//���� ��
	static Scanner sc = null;
	
	//int[����][����]
	public static void main(String[] args) {
		
		
		sc = new Scanner(System.in);
		//�ʱ�ȭ
		t = sc.nextInt();
		for(int i = 0; i < t; i++){
			//�ʱ�ȭ
			//�� ���� �� ���� �ɱ�
			mapSetting();
	
			//���� �����̱� ���� (������ ���� ��ġ)
			for(int yy = 0; yy < map[0].length; yy++){
				for(int xx = 0; xx < map.length; xx++){
					//�� Ž���ϸ鼭 ���߰� �ִ� ������ ���� �Ѹ���
					if(map[xx][yy] == 1){
						//���࿡ ���߸� ó�� �湮�� ���̿��ٸ� true
						if(dfs(xx, yy)){
							cnt++;
						}
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

	private static boolean dfs(int mX, int mY) {
		if(visited[mX][mY])	//�̹� �湮�ߴٸ� �ǵ��� ������
			return false;
		
		visited[mX][mY] = true;
		//���� ���� ����
		//mX-1 >= 0  �̸�, Ž�� ���	(��)
		//mX+1 < m 	�̸�, Ž�� ���	(����)
		//mY-1 >= 0  �̸�, Ž�� ���	(��)
		//mY+1 < n 	�̸�, Ž�� ���	(�Ʒ�)
		if(mX-1 >= 0){	 
			if(map[mX-1][mY] == 1){	dfs(mX-1, mY);	}
		}
		if(mX+1 <  m){	 
			if(map[mX+1][mY] == 1){	dfs(mX+1, mY);	}
		}
		if(mY-1 >= 0){	 
			if(map[mX][mY-1] == 1){	dfs(mX, mY-1);	}
		}
		if(mY+1 <  n){	 
			if(map[mX][mY+1] == 1){	dfs(mX, mY+1);	}
		}
		return true;
	}

	private static void mapSetting() {
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		x = 0;
		y = 0;
		cnt = 0;
		
		//�� ����
		map = new int[m][n];			//��, ��
		visited = new boolean[m][n];	//��, ��
		//���� �ɱ�
		for(int i = 0; i < k; i++){
			int choX = sc.nextInt();	//Y�� ��, ��
			int choY = sc.nextInt();	//X�� ��, ��
			map[choX][choY] = 1;
		}
	}
}