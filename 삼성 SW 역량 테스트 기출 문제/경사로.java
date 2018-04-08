package samsung01;

import java.util.Scanner;

public class samsung04 {
	
	static int N = 0; //맵크기
	static int L = 0; //경사로 길이
	static int map[][] = null; //맵
	static boolean l_map[] = null;	//길 경사로 여부
	static int cnt = 0; 	//성공한 길 카운트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		
		map = new int[N][N];
		l_map = new boolean[N];
		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map[i][j] = sc.nextInt();
			}
		}
		//가로일 땐 (row, 0)만, 세로일 땐, (0, col)
		for(int i = 0 ; i < map.length; i++){
			row_dfs(i, 0);	
			//초기화
			l_map = new boolean[N];
		}
		
		//가로일 땐 (row, 0)만, 세로일 땐, (0, col)
		for(int i = 0 ; i < map[0].length; i++){
			col_dfs(0, i);	
			//초기화
			l_map = new boolean[N];
		}
		
		System.out.println(cnt);
	}

	//어떠한 요구 조건에 일치하지 않으면 그냥 return, 모두 성공하면 cnt++하고 return
	public static void row_dfs(int row, int col) {
		//System.out.println("현재 위치 : " + row+"/"+col);
		//1. 한줄씩 들어감	[row][col]이라 하자
		//현재 위치 if(col+1 == map[0].length) 만약 이러면 성공한거니까 cnt++ return;
		if(col+1 == map[0].length){
			//System.out.println((row+1) +" 줄 성공!");
			cnt++;
			return;
		}
		//2. 현재 위치와 다음 위치의 차이를 구해
		//2-1. ★서로의 차이가 2이상이면 실패 현재 row 종료
		if(map[row][col] - map[row][col+1] > 1){
			//System.out.println("실패1");
			return;
		}
		//2-2. 서로의 차이가 1이면 현재 위치가 1 높은 것
		else if(map[row][col] - map[row][col+1] == 1){
			//2-2-1. 우선 경사로를 놓을 만한 자리가 있는지
			//우선 가로 맵의 크기 안에 들어가는지 비교 
			if(col+L < map[0].length){
				//그다음, L만큼이 평평한지
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row][col+1+i]; 
				}
				
				// 이 말은 경사로 놓을 자리가 평평치 않다는 것 return하고 현재 row 종료
				if(map[row][col+1] != (loadCheck/L)) {
					//System.out.println("실패2");
					return;
				}
			}else{
				//System.out.println("실패3");
				return;
			}
			//2-2-2. 경사로를 놓는다	//현재 위치 다음에다가 L길이만큼 놓는다
			for(int i = 0; i < L; i++){
				l_map[col+1+i] = true;
			}
			//2-2-3. 경사로를 다 놓고 이제 경사로 다음 위치로 가야함
				//경사로 다내려오고 다음 위치가 없을때
			if(col+L < map[0].length){
				row_dfs(row, col+L);
			}

		//2-3. 서로의 차이가 -1이면 현재 위치가 1 더 낮은 것
		}else if(map[row][col] - map[row][col+1] == -1){
			//구현해야댐
			//1. 경사로 놓을 자리가 있는지 판단해야댐
			//	1.1 먼저 경사로 놓을 공간이 있는가? 
			if(col-L+1 < 0){ 
				//System.out.println("실패1-1");
				return; 
			}else{
				// 자리는 되는걸 확인했음 그럼 땅은 평평한지 확인
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row][col-i]; 
				}
				// 이 말은 경사로 놓을 자리가 평평치 않다는 것 return하고 현재 row 종료
				if(map[row][col] != (loadCheck/L)) {
					//System.out.println("실패1-2");
					return;
				}
			}
			//2-2-2. 경사로를 놓는다	//현재 위치 다음에다가 L길이만큼 놓는다
			//이미 존재하면 실패
			for(int i = 0; i < L; i++){
				if(!l_map[col-i]){
				l_map[col-i] = true;
				}else {
					//System.out.println("실패1-3");
					return;
				}
			}
			
			//경사로를 놓고 현재 위치에서 다음으로 이동
			row_dfs(row, col+1);
			//똑같으니 다음으로 이동
		}else if(map[row][col] - map[row][col+1] == 0){
			row_dfs(row, col+1);
		}
			
	}
	

	//어떠한 요구 조건에 일치하지 않으면 그냥 return, 모두 성공하면 cnt++하고 return
	public static void col_dfs(int row, int col) {
		//System.out.println("현재 위치 : " + row+"/"+col);
		//1. 한줄씩 들어감	[row][col]이라 하자
		//현재 위치 if(col+1 == map[0].length) 만약 이러면 성공한거니까 cnt++ return;
		if(row+1 == map[0].length){
			//System.out.println((col+1) +" 줄 성공!");
			cnt++;
			return;
		}
		//2. 현재 위치와 다음 위치의 차이를 구해
		//2-1. ★서로의 차이가 2이상이면 실패 현재 col 종료
		if(map[row][col] - map[row+1][col] > 1){
			//System.out.println("실패1");
			return;
		}
		//2-2. 서로의 차이가 1이면 현재 위치가 1 높은 것
		else if(map[row][col] - map[row+1][col] == 1){
			//2-2-1. 우선 경사로를 놓을 만한 자리가 있는지
			//우선 가로 맵의 크기 안에 들어가는지 비교 
			if(row+L < map.length){
				//그다음, L만큼이 평평한지
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row+1+i][col]; 
				}
				// 이 말은 경사로 놓을 자리가 평평치 않다는 것 return하고 현재 col 종료
				if(map[row+1][col] != (loadCheck/L)) {
					//System.out.println("실패2");
					return;
				}
			}else{
				//System.out.println("실패3");
				return;
			}
			//2-2-2. 경사로를 놓는다	//현재 위치 다음에다가 L길이만큼 놓는다
			for(int i = 0; i < L; i++){
				l_map[row+1+i] = true;
			}
			//2-2-3. 경사로를 다 놓고 이제 경사로 다음 위치로 가야함
				//경사로 다내려오고 다음 위치가 없을때
			if(row+L < map[0].length){
				col_dfs(row+L, col);
			}

		//2-3. 서로의 차이가 -1이면 현재 위치가 1 더 낮은 것
		}else if(map[row][col] - map[row+1][col] == -1){
			//구현해야댐
			//1. 경사로 놓을 자리가 있는지 판단해야댐
			//	1.1 먼저 경사로 놓을 공간이 있는가? 
			if(row-L+1 < 0){ 
				//System.out.println("실패1-1");
				return; 
			}else{
				// 자리는 되는걸 확인했음 그럼 땅은 평평한지 확인
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row-i][col]; 
				}
				// 이 말은 경사로 놓을 자리가 평평치 않다는 것 return하고 현재 col 종료
				if(map[row][col] != (loadCheck/L)) {
					//System.out.println("실패1-2");
					return;
				}
			}
			//2-2-2. 경사로를 놓는다	//현재 위치 다음에다가 L길이만큼 놓는다
			//이미 존재하면 실패
			for(int i = 0; i < L; i++){
				if(!l_map[row-i]){
				l_map[row-i] = true;
				}else {
					//System.out.println("실패1-3");
					return;
				}
			}
			
			//경사로를 놓고 현재 위치에서 다음으로 이동
			col_dfs(row+1, col);
			//똑같으니 다음으로 이동
		}else if(map[row][col] - map[row+1][col] == 0){
			col_dfs(row+1, col);
		}
			
	}

}
