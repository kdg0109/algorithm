package samsung01;

import java.util.Scanner;

public class samsung02 {
	static int t = 0; 			//테스트 케이스
	static int m = 0; 			//배추밭 가로 길이
	static int n = 0;			//배추밭 세로 길이
	static int k = 0;			//배추를 심은 개수
	static int x, y = 0;		//배추 좌표 XY
	static int map[][] = null;	//배추 밭
	static boolean visited[][] = null;	//방문 여부 
	static int cnt = 0;			//벌레 수
	static Scanner sc = null;
	
	//int[가로][세로]
	public static void main(String[] args) {
		
		
		sc = new Scanner(System.in);
		//초기화
		t = sc.nextInt();
		for(int i = 0; i < t; i++){
			//초기화
			//맵 세팅 및 배추 심기
			mapSetting();
	
			//벌레 움직이기 시작 (벌레를 놓는 위치)
			for(int yy = 0; yy < map[0].length; yy++){
				for(int xx = 0; xx < map.length; xx++){
					//쭉 탐색하면서 배추가 있는 곳에만 벌레 뿌리기
					if(map[xx][yy] == 1){
						//만약에 배추를 처음 방문한 곳이였다면 true
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
		if(visited[mX][mY])	//이미 방문했다면 되돌아 나가기
			return false;
		
		visited[mX][mY] = true;
		//제한 구역 설정
		//mX-1 >= 0  이면, 탐색 허용	(왼)
		//mX+1 < m 	이면, 탐색 허용	(오른)
		//mY-1 >= 0  이면, 탐색 허용	(위)
		//mY+1 < n 	이면, 탐색 허용	(아래)
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
		
		//맵 세팅
		map = new int[m][n];			//열, 행
		visited = new boolean[m][n];	//열, 행
		//배추 심기
		for(int i = 0; i < k; i++){
			int choX = sc.nextInt();	//Y가 즉, 행
			int choY = sc.nextInt();	//X가 즉, 열
			map[choX][choY] = 1;
		}
	}
}