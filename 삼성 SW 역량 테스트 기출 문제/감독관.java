package samsung01;

import java.util.Scanner;

/**
총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. 
i번 시험장에 있는 응시자의 수는 Ai명이다.

감독관은 총감독관과 부감독관으로 두 종류가 있다. 
총감독관은 한 방에서 감시할 수 있는 응시자의 수가 B명이고, 
부감독관은 한 방에서 감시할 수 있는 응시자의 수가 C명이다.

각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
 */
public class samsung06 {
	static int N = 0; 			//시험장의 개수
	static int[] A = null;		//각 시험장에 있는 응시자의 수
	static int B = 0;			//총감독관이 한 방에서 감시할 수 있는 수
	static int C = 0;			//부감독관이 한 방에서 감시할 수 있는 수
	
	static long cnt = 0;			//감독관 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new int[N];
		for(int i = 0; i < N; i++){
			A[i] = sc.nextInt();
		}
		B = sc.nextInt();
		C = sc.nextInt();
		
		for(int i = 0; i < N; i++){
			fake_dfs(A[i]);
		}
		System.out.println(cnt);
	}

	//매개변수 classNum : 각 반에 감독하기 위한 수
	private static void fake_dfs(int classNum) {
		int num = classNum;

		num -= B;
		cnt++;
		
		if(num > 0){
			int tmp = num/C;
			
			if(num%C == 0){
				cnt += tmp;
			}else{
				cnt += tmp+1;
			}
		}
	}
}