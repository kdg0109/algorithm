package samsung01;

import java.util.ArrayList;
import java.util.Scanner;

//세로, 네모, ㄴ, 
//대칭, 회전
public class samsung03 {
	static int N = 0; 			//세로 즉, 가로 줄의 개수
	static int M = 0;			//가로 즉, 세로 줄의 개수
	static int map[][] = null;	//종이
	static int maxSum = 0;		//큰 결과값
	
	//세로 막대
	static int Nstick[][] = null;
	//가로 막대
	static int Mstick[][] = null;
	
	//네모
	static int nemo[][] = null;
	//L자 
	static int R1[][] = null;
	//L자 대칭
	static int R2[][] = null;
	//ㄴ자
	static int R3[][] = null;
	//ㄴ자 대칭
	static int R4[][] = null;
	//ㄱ자
	static int R5[][] = null;
	//ㄱ자 대칭
	static int R6[][] = null;
	//7자
	static int R7[][] = null;
	//7자 대칭
	static int R8[][] = null;
	
	//s? 상
	static int S1[][] = null;
	//s? 상 대칭
	static int S2[][] = null;
	//s? 가로
	static int S3[][] = null;
	//s? 가로 대칭
	static int S4[][] = null;
	
	//ㅗ
	static int M1[][] = null;
	//ㅜ
	static int M2[][] = null;
	//ㅓ
	static int M3[][] = null;
	//ㅏ
	static int M4[][] = null;
	
	//사이즈를 통해 제한 범위를 확인
	static int objSize[][] = new int[19][2];	//각 오브젝트별 가로x세로사이즈

	static Scanner sc = null;
	
	static ArrayList<int[][]> array = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		array = new ArrayList<>();
		N = sc.nextInt();
		M = sc.nextInt();
		
		//맵 세팅과 테트로미노 생성
		settingInit();
		
		for(int i = 0; i < array.size(); i++){
			seachScore(array.get(i), objSize[i][0]-1, objSize[i][1]-1);
		}
		
//		seachScore(array.get(17), objSize[17][0]-1, objSize[17][1]-1);
		System.out.println(maxSum);
	}

	//합의 최댓값을 출력
	private static void seachScore(int[][] obj, int objSizeN, int objSizeM) {
		dfs(obj, 0, 0, objSizeN, objSizeM);
	}

	//한 객체에 대한 이동값이고 리턴은 합계값
	private static void dfs(int[][] obj, int mX, int mY, int objSizeN, int objSizeM) {
		//1. mX, mY는 테트로미노 왼쪽 상단의 기준점임
		//2. objSizeN는 가로줄의 개수 objSizeM은 세로줄의 개수 , 즉, objSizeN x objSizeM
		//3. 먼저 범위를 측정하는데 mX + objSizeM 오른쪽 넘어가지 않고 mY + objSizeN 맵 아래를 넘어가지 않는다면
		//	3-1. 해당 위치에서 objSize[i][j] == 1인 것에 매핑되는 맵 숫자 더함 
		//4. 만약 넘어간다면, 오른쪽을 넘가면 mX를 0으로 하고 mY를 1로 넘기고 dfs 
		//5. mY + objSizeN 맵 아래를 넘어가지 않는다면
		//범위 제한
		//자원 추출

		int sum = 0;
		if((mX + objSizeM) < map[0].length && (mY + objSizeN) < map.length){
			//자원 추출
//			System.out.println("mX : " + mX+ ", mY : " + mY + ", objSizeN : " +objSizeN + ", objSizeM : " +objSizeM);
			
			//오브젝트 크기만큼의 범위를 구하고,
			// 그 안에서 오브젝트 값과 곱
			for(int i = 0; i < obj.length; i++){
				for(int j = 0; j < obj[0].length; j++){
					sum += map[mY + i][mX + j]*obj[i][j];
				}
			}
			//자원추출하고
			if(maxSum < sum){
				maxSum = sum;
			}
			if((mX + objSizeM + 1) < map[0].length){
				dfs(obj, mX+1, mY, objSizeN, objSizeM);
			}else if((mY + objSizeN + 1) < map.length){
				mX = 0;
				dfs(obj, mX, mY+1, objSizeN, objSizeM);
			}
		}
		
	}

	private static void settingInit() {
		map = new int[N][M]; //가로 줄, 세로 줄
		for(int i = 0;i < map.length;i++){
			for(int j = 0;j < map[0].length;j++){
				map[i][j] = sc.nextInt();
			}
		}

		stick();
		nemo();
		r();
		s();
		m();

	}
	//모음처럼 생긴거
	private static void m() {
		//ㅗ
		M1 = new int[][]{	{0, 1, 0}, 
							{1, 1, 1}
		};
		objSize[15][0] = 2;
		objSize[15][1] = 3;
		//ㅜ
		M2 = new int[][]{	{1, 1, 1}, 
							{0, 1, 0}
		};
		objSize[16][0] = 2;
		objSize[16][1] = 3;
		//ㅏ
		M3 = new int[][]{	{1, 0}, 
							{1, 1}, 
							{1, 0}
		};
		objSize[17][0] = 3;
		objSize[17][1] = 2;
		//ㅓ
		M4 = new int[][]{	{0, 1}, 
							{1, 1}, 
							{0, 1}
		};
		objSize[18][0] = 3;
		objSize[18][1] = 2;
		array.add(M1);
		array.add(M2);
		array.add(M3);
		array.add(M4);
	}
	//S? 처럼 생긴거
	private static void s() {
		//s? 상
		S1 = new int[][]{	{1, 0}, 
							{1, 1}, 
							{0, 1}
		};
		objSize[11][0] = 3;
		objSize[11][1] = 2;
		//s? 상 대칭
		S2 = new int[][]{	{0, 1}, 
							{1, 1}, 
							{1, 0}
		};
		objSize[12][0] = 3;
		objSize[12][1] = 2;
		//s? 가로
		S3 = new int[][]{	{0, 1, 1}, 
							{1, 1, 0}
		};
		objSize[13][0] = 2;
		objSize[13][1] = 3;
		//s? 가로 대칭
		S4 = new int[][]{	{1, 1, 0}, 
							{0, 1, 1}
		};
		objSize[14][0] = 2;
		objSize[14][1] = 3;

		array.add(S1);
		array.add(S2);
		array.add(S3);
		array.add(S4);
	}
	
	private static void r() {
		// L자
		R1 = new int[][]{	{1, 0}, 
							{1, 0}, 
							{1, 1}
		};
		objSize[3][0] = 3;
		objSize[3][1] = 2;
		// L자 대칭
		R2 = new int[][]{	{0, 1}, 
							{0, 1}, 
							{1, 1}
		};
		objSize[4][0] = 3;
		objSize[4][1] = 2;
		// ㄴ자
		R3 = new int[][]{	{1, 0, 0}, 
							{1, 1, 1}
		};
		objSize[5][0] = 2;
		objSize[5][1] = 3;
		// ㄴ자 대칭
		R4 = new int[][]{	{0, 0, 1}, 
							{1, 1, 1}
		};
		objSize[6][0] = 2;
		objSize[6][1] = 3;
		// ㄱ자
		R5 = new int[][]{	{1, 1, 1}, 
							{0, 0, 1}
		};
		objSize[7][0] = 2;
		objSize[7][1] = 3;
		// ㄱ자 대칭
		R6 = new int[][]{	{1, 1, 1}, 
							{1, 0, 0}
		};
		objSize[8][0] = 2;
		objSize[8][1] = 3;
		// 7자
		R7 = new int[][]{	{1, 1}, 
							{0, 1}, 
							{0, 1}
		};
		objSize[9][0] = 3;
		objSize[9][1] = 2;
		// 7자 대칭
		R8 = new int[][]{	{1, 1}, 
							{1, 0}, 
							{1, 0}
		};
		objSize[10][0] = 3;
		objSize[10][1] = 2;
		

		array.add(R1);
		array.add(R2);
		array.add(R3);
		array.add(R4);
		array.add(R5);
		array.add(R6);
		array.add(R7);
		array.add(R8);
	}

	private static void nemo() {
		nemo = new int[][]{		{1, 1}, 
								{1, 1}
		};
		objSize[2][0] = 2;
		objSize[2][1] = 2;
		array.add(nemo);
	}

	private static void stick() {
		Nstick = new int[][]{	{1}, 
								{1},
								{1},
								{1}
		};
		objSize[0][0] = 4;
		objSize[0][1] = 1;
		Mstick = new int[][]{	{1, 1, 1, 1}
		};
		objSize[1][0] = 1;
		objSize[1][1] = 4;
		

		array.add(Nstick);
		array.add(Mstick);
	}
}