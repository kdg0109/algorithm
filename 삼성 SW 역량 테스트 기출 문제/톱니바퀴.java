package samsung01;
import java.util.Scanner;
/**
 * 첫째 줄에 1번 톱니바퀴의 상태, 
 * 둘째 줄에 2번 톱니바퀴의 상태, 
 * 셋째 줄에 3번 톱니바퀴의 상태, 
 * 넷째 줄에 4번 톱니바퀴의 상태가 주어진다. 
 * 
 * 상태는 8개의 정수로 이루어져 있고, 
 * 12시방향부터 시계방향 순서대로 주어진다. 
 * N극은 0, S극은 1로 나타나있다.
 * 
 * 다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 
 * 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 
 * 각 방법은 두 개의 정수로 이루어져 있고, 
 * 첫 번째 정수는 회전시킨 톱니바퀴의 번호, 
 * 두 번째 정수는 방향이다. 
 * 
 * 방향이 1인 경우는 시계 방향이고, 
 * -1인 경우는 반시계 방향이다.
 * 
 */

public class samsung01 {
	static int k = 0; 									//회전 횟수
	final static int RIGHT_TURN = 1;			//시계 방향
	final static int LEFT_TURN = -1;			//반시계 방향
	static int start_pos_init = 0;
	static int pos = 0;							//초기값
	static int direction = 0;					//방향
	
	static int wheel [][] = new int[8][4];		//각 행은 톱니바퀴임 [열][행] 임!!!!
	static int mRow = 0;							//좌, 우 이동 때 쓰이는 열좌표
	
	static boolean visited[] = new boolean[4];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//초기화
		for(int i = 0; i < 4; i++){
			String array = sc.next();
			for(int j = 0; j < array.length(); j++){
				wheel[j][i] = Integer.parseInt(array.substring(j,j+1));	//열행임
			}
		}
		k = sc.nextInt();
		
		for(int a = 0; a < k; a++){
			pos = sc.nextInt() - 1;
			direction = sc.nextInt();		//왼쪽이냐 오른쪽이냐
			
			start_pos_init = pos;
			dfs(pos, direction);
			visited = new boolean[4];		//초기화
		}
		int result = 0;
		if(wheel[0][0] == 1){	result += 1;	}
		if(wheel[0][1] == 1){	result += 2;	}
		if(wheel[0][2] == 1){	result += 4;	}
		if(wheel[0][3] == 1){	result += 8;	}
		System.out.println(result);
	}
	

	static void dfs(int pos, int direction){
		if(visited[pos])
			return;

		visited[pos] = true;
		
		//들어간다는 것 자체가 바꿀게 있다는 것임
		if(pos < 3 && visited[pos+1] != true && wheel[2][pos] != wheel[6][pos+1]){
			dfs(pos+1, direction*(-1));
		}
		if(pos > 0 && visited[pos-1] != true && wheel[6][pos] != wheel[2][pos-1]){
			dfs(pos-1, direction*(-1));
		}

		if(direction == RIGHT_TURN){
			int start_tmp = 0;
			int tmp = 0;
			start_tmp = wheel[7][pos];
			for(int i = 7; i > 0; i--){
				wheel[i][pos] = wheel[i-1][pos];
			}
			wheel[0][pos] = start_tmp;

		}else{
			int end_tmp = 0;
			int tmp = 0;
			end_tmp = wheel[0][pos];
			for(int i = 0; i < 7; i++){
				wheel[i][pos] = wheel[i+1][pos];
			}
			wheel[7][pos] = end_tmp;
		}
	}
}
