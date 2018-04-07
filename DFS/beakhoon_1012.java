package samsung01;
import java.util.Scanner;
/**
 * ù° �ٿ� 1�� ��Ϲ����� ����, 
 * ��° �ٿ� 2�� ��Ϲ����� ����, 
 * ��° �ٿ� 3�� ��Ϲ����� ����, 
 * ��° �ٿ� 4�� ��Ϲ����� ���°� �־�����. 
 * 
 * ���´� 8���� ������ �̷���� �ְ�, 
 * 12�ù������ �ð���� ������� �־�����. 
 * N���� 0, S���� 1�� ��Ÿ���ִ�.
 * 
 * �ټ�° �ٿ��� ȸ�� Ƚ�� K(1 �� K �� 100)�� �־�����. 
 * ���� K�� �ٿ��� ȸ����Ų ����� ������� �־�����. 
 * �� ����� �� ���� ������ �̷���� �ְ�, 
 * ù ��° ������ ȸ����Ų ��Ϲ����� ��ȣ, 
 * �� ��° ������ �����̴�. 
 * 
 * ������ 1�� ���� �ð� �����̰�, 
 * -1�� ���� �ݽð� �����̴�.
 * 
 */

public class samsung01 {
	static int k = 0; 									//ȸ�� Ƚ��
	final static int RIGHT_TURN = 1;			//�ð� ����
	final static int LEFT_TURN = -1;			//�ݽð� ����
	static int start_pos_init = 0;
	static int pos = 0;							//�ʱⰪ
	static int direction = 0;					//����
	
	static int wheel [][] = new int[8][4];		//�� ���� ��Ϲ����� [��][��] ��!!!!
	static int mRow = 0;							//��, �� �̵� �� ���̴� ����ǥ
	
	static boolean visited[] = new boolean[4];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//�ʱ�ȭ
		for(int i = 0; i < 4; i++){
			String array = sc.next();
			for(int j = 0; j < array.length(); j++){
				wheel[j][i] = Integer.parseInt(array.substring(j,j+1));	//������
			}
		}
		k = sc.nextInt();
		
		for(int a = 0; a < k; a++){
			pos = sc.nextInt() - 1;
			direction = sc.nextInt();		//�����̳� �������̳�
			
			start_pos_init = pos;
			dfs(pos, direction);
			visited = new boolean[4];		//�ʱ�ȭ
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
		
		//���ٴ� �� ��ü�� �ٲܰ� �ִٴ� ����
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
