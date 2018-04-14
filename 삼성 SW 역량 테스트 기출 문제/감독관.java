package samsung01;

import java.util.Scanner;

/**
�� N���� �������� �ְ�, ������ �����帶�� �����ڵ��� �ִ�. 
i�� �����忡 �ִ� �������� ���� Ai���̴�.

�������� �Ѱ������� �ΰ��������� �� ������ �ִ�. 
�Ѱ������� �� �濡�� ������ �� �ִ� �������� ���� B���̰�, 
�ΰ������� �� �濡�� ������ �� �ִ� �������� ���� C���̴�.

������ �����忡 �Ѱ������� ���� 1�� �־�� �ϰ�, �ΰ������� ���� �� �־ �ȴ�.
 */
public class samsung06 {
	static int N = 0; 			//�������� ����
	static int[] A = null;		//�� �����忡 �ִ� �������� ��
	static int B = 0;			//�Ѱ������� �� �濡�� ������ �� �ִ� ��
	static int C = 0;			//�ΰ������� �� �濡�� ������ �� �ִ� ��
	
	static long cnt = 0;			//������ ��
	
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

	//�Ű����� classNum : �� �ݿ� �����ϱ� ���� ��
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