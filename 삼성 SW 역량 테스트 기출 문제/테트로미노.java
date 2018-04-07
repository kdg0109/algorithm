package samsung01;

import java.util.ArrayList;
import java.util.Scanner;

//����, �׸�, ��, 
//��Ī, ȸ��
public class samsung03 {
	static int N = 0; 			//���� ��, ���� ���� ����
	static int M = 0;			//���� ��, ���� ���� ����
	static int map[][] = null;	//����
	static int maxSum = 0;		//ū �����
	
	//���� ����
	static int Nstick[][] = null;
	//���� ����
	static int Mstick[][] = null;
	
	//�׸�
	static int nemo[][] = null;
	//L�� 
	static int R1[][] = null;
	//L�� ��Ī
	static int R2[][] = null;
	//����
	static int R3[][] = null;
	//���� ��Ī
	static int R4[][] = null;
	//����
	static int R5[][] = null;
	//���� ��Ī
	static int R6[][] = null;
	//7��
	static int R7[][] = null;
	//7�� ��Ī
	static int R8[][] = null;
	
	//s? ��
	static int S1[][] = null;
	//s? �� ��Ī
	static int S2[][] = null;
	//s? ����
	static int S3[][] = null;
	//s? ���� ��Ī
	static int S4[][] = null;
	
	//��
	static int M1[][] = null;
	//��
	static int M2[][] = null;
	//��
	static int M3[][] = null;
	//��
	static int M4[][] = null;
	
	//����� ���� ���� ������ Ȯ��
	static int objSize[][] = new int[19][2];	//�� ������Ʈ�� ����x���λ�����

	static Scanner sc = null;
	
	static ArrayList<int[][]> array = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		array = new ArrayList<>();
		N = sc.nextInt();
		M = sc.nextInt();
		
		//�� ���ð� ��Ʈ�ι̳� ����
		settingInit();
		
		for(int i = 0; i < array.size(); i++){
			seachScore(array.get(i), objSize[i][0]-1, objSize[i][1]-1);
		}
		
//		seachScore(array.get(17), objSize[17][0]-1, objSize[17][1]-1);
		System.out.println(maxSum);
	}

	//���� �ִ��� ���
	private static void seachScore(int[][] obj, int objSizeN, int objSizeM) {
		dfs(obj, 0, 0, objSizeN, objSizeM);
	}

	//�� ��ü�� ���� �̵����̰� ������ �հ谪
	private static void dfs(int[][] obj, int mX, int mY, int objSizeN, int objSizeM) {
		//1. mX, mY�� ��Ʈ�ι̳� ���� ����� ��������
		//2. objSizeN�� �������� ���� objSizeM�� �������� ���� , ��, objSizeN x objSizeM
		//3. ���� ������ �����ϴµ� mX + objSizeM ������ �Ѿ�� �ʰ� mY + objSizeN �� �Ʒ��� �Ѿ�� �ʴ´ٸ�
		//	3-1. �ش� ��ġ���� objSize[i][j] == 1�� �Ϳ� ���εǴ� �� ���� ���� 
		//4. ���� �Ѿ�ٸ�, �������� �Ѱ��� mX�� 0���� �ϰ� mY�� 1�� �ѱ�� dfs 
		//5. mY + objSizeN �� �Ʒ��� �Ѿ�� �ʴ´ٸ�
		//���� ����
		//�ڿ� ����

		int sum = 0;
		if((mX + objSizeM) < map[0].length && (mY + objSizeN) < map.length){
			//�ڿ� ����
//			System.out.println("mX : " + mX+ ", mY : " + mY + ", objSizeN : " +objSizeN + ", objSizeM : " +objSizeM);
			
			//������Ʈ ũ�⸸ŭ�� ������ ���ϰ�,
			// �� �ȿ��� ������Ʈ ���� ��
			for(int i = 0; i < obj.length; i++){
				for(int j = 0; j < obj[0].length; j++){
					sum += map[mY + i][mX + j]*obj[i][j];
				}
			}
			//�ڿ������ϰ�
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
		map = new int[N][M]; //���� ��, ���� ��
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
	//����ó�� �����
	private static void m() {
		//��
		M1 = new int[][]{	{0, 1, 0}, 
							{1, 1, 1}
		};
		objSize[15][0] = 2;
		objSize[15][1] = 3;
		//��
		M2 = new int[][]{	{1, 1, 1}, 
							{0, 1, 0}
		};
		objSize[16][0] = 2;
		objSize[16][1] = 3;
		//��
		M3 = new int[][]{	{1, 0}, 
							{1, 1}, 
							{1, 0}
		};
		objSize[17][0] = 3;
		objSize[17][1] = 2;
		//��
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
	//S? ó�� �����
	private static void s() {
		//s? ��
		S1 = new int[][]{	{1, 0}, 
							{1, 1}, 
							{0, 1}
		};
		objSize[11][0] = 3;
		objSize[11][1] = 2;
		//s? �� ��Ī
		S2 = new int[][]{	{0, 1}, 
							{1, 1}, 
							{1, 0}
		};
		objSize[12][0] = 3;
		objSize[12][1] = 2;
		//s? ����
		S3 = new int[][]{	{0, 1, 1}, 
							{1, 1, 0}
		};
		objSize[13][0] = 2;
		objSize[13][1] = 3;
		//s? ���� ��Ī
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
		// L��
		R1 = new int[][]{	{1, 0}, 
							{1, 0}, 
							{1, 1}
		};
		objSize[3][0] = 3;
		objSize[3][1] = 2;
		// L�� ��Ī
		R2 = new int[][]{	{0, 1}, 
							{0, 1}, 
							{1, 1}
		};
		objSize[4][0] = 3;
		objSize[4][1] = 2;
		// ����
		R3 = new int[][]{	{1, 0, 0}, 
							{1, 1, 1}
		};
		objSize[5][0] = 2;
		objSize[5][1] = 3;
		// ���� ��Ī
		R4 = new int[][]{	{0, 0, 1}, 
							{1, 1, 1}
		};
		objSize[6][0] = 2;
		objSize[6][1] = 3;
		// ����
		R5 = new int[][]{	{1, 1, 1}, 
							{0, 0, 1}
		};
		objSize[7][0] = 2;
		objSize[7][1] = 3;
		// ���� ��Ī
		R6 = new int[][]{	{1, 1, 1}, 
							{1, 0, 0}
		};
		objSize[8][0] = 2;
		objSize[8][1] = 3;
		// 7��
		R7 = new int[][]{	{1, 1}, 
							{0, 1}, 
							{0, 1}
		};
		objSize[9][0] = 3;
		objSize[9][1] = 2;
		// 7�� ��Ī
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