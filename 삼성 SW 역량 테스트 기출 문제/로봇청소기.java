package samsung01;

import java.io.InputStream;
import java.util.Scanner;

public class samsung05 {
	static int N = 0;		//세로
	static int M = 0; 		//가로
	static int r = 0;	//로봇 청소기 시작 위치 행
	static int c = 0;	//로봇 청소기 시작 위치 열
	static int d = 0;	//로봇 청소기 시점
	
	final static int NN = 0;	//북쪽
	final static int EE = 1;	//동쪽
	final static int SS = 2;	//남쪽
	final static int WW = 3;	//서쪽
	
	static int map[][] = null;			//맵
	
	static boolean visited[][] = null;	//방문여부
	static int clear = 0;			//청소한 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		//로봇 시점도 초기화

		//directionSetting(d);
		
		
		map = new int[N][M];
		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map[i][j] = sc.nextInt();
			}
		}
		dfs(r, c, false, 0);
//		visited = new boolean[N][M];
	} 
	private static int directionSetting(int dd) {
//		n
//	w		e
//		s
		if(dd == NN){
			return WW;
		}else if(dd == EE){
			return NN;
		}else if(dd == SS){
			return EE;
		}else{
			return SS;
		}
		
	}
	//rotate_cnt는 회전 횟수이고 지금이 4번째이면 아무것도 없다는 것
	//rotate가 false는 이동한거고 true면 단순 회전
	static void dfs(int row, int col, boolean rotate, int rotate_cnt){
		if(rotate_cnt == 9999){
			System.out.println(clear);
			System.exit(0);
		}
		////System.out.println(rotate_cnt);
		//System.out.println(row + "," + col);
		int cnt = rotate_cnt;
		//입장하면 청소한다 
		if(cnt == 0 && !rotate){
			map[row][col] = 2;
			clear++;
		}
		
		////System.out.println(rotate_cnt +" / " + cnt);
		////System.out.println("현재 위치 : " + row + "/"+ col + "이고 보는 방향 " + d);
		if(cnt < 4){
			//회전한다
			d = directionSetting(d);
		}
		////System.out.println(d + "로 눈 돌린다.");
		//System.out.println(cnt+"/"+d);
		//왼쪽이 깨끗한지
		//왼쪽을 청소해야한다면, 왼쪽으로 돌고 (그 왼쪽으로 좌표이동후) dfs
		if(d == NN){
			////System.out.println("바라보는 방향 N");
			if(cnt == 4){
				if(map[row-1][col] == 0){
					////System.out.println("4바퀴돌고 " + (row-1)+"/"+col + "로 움직인다.");
					dfs(row-1, col, false, 0);
				}else{
					if(map[row+1][col] == 0){
						////System.out.println("4바퀴돌고 " + (row-1)+"/"+col + "로 움직인다.");
						dfs(row+1, col, false, 0);
					}else if(map[row+1][col] == 2){
						////System.out.println("4바퀴돌고 " + (row-1)+"/"+col + "로 움직인다.");
						dfs(row+1, col, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row-1][col] == 0){	//깨끗한가
				////System.out.println("4바퀴돌고 " + (row-1)+"/"+col + "로 움직인다.");
				//이동
				dfs(row-1, col, false, 0);
			}else{
				////System.out.println("a 회전");
				dfs(row, col, true, cnt+1);	//회전만
			}
		}else if(d == EE){
			////System.out.println("바라보는 방향 E");
			if(cnt == 4){
				if(map[row][col+1] == 0){
					////System.out.println("4바퀴돌고 " + row+"/"+(col+1) + "로 움직인다.");
					dfs(row, col+1, false, 0);
				}else{
					if(map[row][col-1] == 0){
						dfs(row, col-1, false, 0);
					}else if(map[row][col-1] == 2){
						////System.out.println("4바퀴돌고 " + (row-1)+"/"+col + "로 움직인다.");
						dfs(row, col-1, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row][col+1] == 0){	//깨끗한가
				////System.out.println(row+"/"+(col+1) + "로 움직인다.");
				//이동
				dfs(row, col+1, false, 0);
			}else{
				////System.out.println("b 회전");
				dfs(row, col, true, cnt+1);	//회전만
			}
		}else if(d == SS){
			////System.out.println("바라보는 방향 S");
			if(cnt == 4){
				if(map[row+1][col] == 0){	//깨끗한가
					//이동
					////System.out.println("4바퀴돌고 " + (row+1)+"/"+col + "로 움직인다.");
					dfs(row+1, col, false, 0);
				}else{
					if(map[row-1][col] == 0){
						dfs(row-1, col, false, 0);
					}else if(map[row-1][col] == 2){
						////System.out.println("4바퀴돌고 " + (row-1)+"/"+col + "로 움직인다.");
						dfs(row-1, col, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row+1][col] == 0){	//깨끗한가
				////System.out.println((row+1)+"/"+col + "로 움직인다.");
				//이동
				dfs(row+1, col, false, 0);
			}else{
				////System.out.println("c 회전");
				dfs(row, col, true, cnt+1);	//회전만
			}
		}else if(d == WW){
			////System.out.println("바라보는 방향 W");
			if(cnt == 4){
				if(map[row][col-1] == 0){	//깨끗한가
					////System.out.println("4바퀴돌고 " + row+"/"+(col-1) + "로 움직인다.");
					//이동
					dfs(row, col-1, false, 0);
				}else{
					if(map[row][col+1] == 0){
						dfs(row, col+1, false, 0);
					}else if(map[row][col+1] == 2){
						////System.out.println("4바퀴돌고 " + (row-1)+"/"+col + "로 움직인다.");
						dfs(row, col+1, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row][col-1] == 0){	//깨끗한가
				////System.out.println("4바퀴돌고 " + row+"/"+(col-1) + "로 움직인다.");
				//이동
				dfs(row, col-1, false, 0);
			}else{
				////System.out.println("d 회전");
				dfs(row, col, true, cnt+1);	//회전만
			}
		}
		//왼쪽 청소할거 없으면 왼쪽으로 돌고 						dfs
	}
}