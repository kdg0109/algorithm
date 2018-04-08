package samsung01;

import java.util.Scanner;

public class samsung04 {
	
	static int N = 0; //��ũ��
	static int L = 0; //���� ����
	static int map[][] = null; //��
	static boolean l_map[] = null;	//�� ���� ����
	static int cnt = 0; 	//������ �� ī��Ʈ

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
		//������ �� (row, 0)��, ������ ��, (0, col)
		for(int i = 0 ; i < map.length; i++){
			row_dfs(i, 0);	
			//�ʱ�ȭ
			l_map = new boolean[N];
		}
		
		//������ �� (row, 0)��, ������ ��, (0, col)
		for(int i = 0 ; i < map[0].length; i++){
			col_dfs(0, i);	
			//�ʱ�ȭ
			l_map = new boolean[N];
		}
		
		System.out.println(cnt);
	}

	//��� �䱸 ���ǿ� ��ġ���� ������ �׳� return, ��� �����ϸ� cnt++�ϰ� return
	public static void row_dfs(int row, int col) {
		//System.out.println("���� ��ġ : " + row+"/"+col);
		//1. ���پ� ��	[row][col]�̶� ����
		//���� ��ġ if(col+1 == map[0].length) ���� �̷��� �����ѰŴϱ� cnt++ return;
		if(col+1 == map[0].length){
			//System.out.println((row+1) +" �� ����!");
			cnt++;
			return;
		}
		//2. ���� ��ġ�� ���� ��ġ�� ���̸� ����
		//2-1. �ڼ����� ���̰� 2�̻��̸� ���� ���� row ����
		if(map[row][col] - map[row][col+1] > 1){
			//System.out.println("����1");
			return;
		}
		//2-2. ������ ���̰� 1�̸� ���� ��ġ�� 1 ���� ��
		else if(map[row][col] - map[row][col+1] == 1){
			//2-2-1. �켱 ���θ� ���� ���� �ڸ��� �ִ���
			//�켱 ���� ���� ũ�� �ȿ� ������ �� 
			if(col+L < map[0].length){
				//�״���, L��ŭ�� ��������
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row][col+1+i]; 
				}
				
				// �� ���� ���� ���� �ڸ��� ����ġ �ʴٴ� �� return�ϰ� ���� row ����
				if(map[row][col+1] != (loadCheck/L)) {
					//System.out.println("����2");
					return;
				}
			}else{
				//System.out.println("����3");
				return;
			}
			//2-2-2. ���θ� ���´�	//���� ��ġ �������ٰ� L���̸�ŭ ���´�
			for(int i = 0; i < L; i++){
				l_map[col+1+i] = true;
			}
			//2-2-3. ���θ� �� ���� ���� ���� ���� ��ġ�� ������
				//���� �ٳ������� ���� ��ġ�� ������
			if(col+L < map[0].length){
				row_dfs(row, col+L);
			}

		//2-3. ������ ���̰� -1�̸� ���� ��ġ�� 1 �� ���� ��
		}else if(map[row][col] - map[row][col+1] == -1){
			//�����ؾߴ�
			//1. ���� ���� �ڸ��� �ִ��� �Ǵ��ؾߴ�
			//	1.1 ���� ���� ���� ������ �ִ°�? 
			if(col-L+1 < 0){ 
				//System.out.println("����1-1");
				return; 
			}else{
				// �ڸ��� �Ǵ°� Ȯ������ �׷� ���� �������� Ȯ��
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row][col-i]; 
				}
				// �� ���� ���� ���� �ڸ��� ����ġ �ʴٴ� �� return�ϰ� ���� row ����
				if(map[row][col] != (loadCheck/L)) {
					//System.out.println("����1-2");
					return;
				}
			}
			//2-2-2. ���θ� ���´�	//���� ��ġ �������ٰ� L���̸�ŭ ���´�
			//�̹� �����ϸ� ����
			for(int i = 0; i < L; i++){
				if(!l_map[col-i]){
				l_map[col-i] = true;
				}else {
					//System.out.println("����1-3");
					return;
				}
			}
			
			//���θ� ���� ���� ��ġ���� �������� �̵�
			row_dfs(row, col+1);
			//�Ȱ����� �������� �̵�
		}else if(map[row][col] - map[row][col+1] == 0){
			row_dfs(row, col+1);
		}
			
	}
	

	//��� �䱸 ���ǿ� ��ġ���� ������ �׳� return, ��� �����ϸ� cnt++�ϰ� return
	public static void col_dfs(int row, int col) {
		//System.out.println("���� ��ġ : " + row+"/"+col);
		//1. ���پ� ��	[row][col]�̶� ����
		//���� ��ġ if(col+1 == map[0].length) ���� �̷��� �����ѰŴϱ� cnt++ return;
		if(row+1 == map[0].length){
			//System.out.println((col+1) +" �� ����!");
			cnt++;
			return;
		}
		//2. ���� ��ġ�� ���� ��ġ�� ���̸� ����
		//2-1. �ڼ����� ���̰� 2�̻��̸� ���� ���� col ����
		if(map[row][col] - map[row+1][col] > 1){
			//System.out.println("����1");
			return;
		}
		//2-2. ������ ���̰� 1�̸� ���� ��ġ�� 1 ���� ��
		else if(map[row][col] - map[row+1][col] == 1){
			//2-2-1. �켱 ���θ� ���� ���� �ڸ��� �ִ���
			//�켱 ���� ���� ũ�� �ȿ� ������ �� 
			if(row+L < map.length){
				//�״���, L��ŭ�� ��������
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row+1+i][col]; 
				}
				// �� ���� ���� ���� �ڸ��� ����ġ �ʴٴ� �� return�ϰ� ���� col ����
				if(map[row+1][col] != (loadCheck/L)) {
					//System.out.println("����2");
					return;
				}
			}else{
				//System.out.println("����3");
				return;
			}
			//2-2-2. ���θ� ���´�	//���� ��ġ �������ٰ� L���̸�ŭ ���´�
			for(int i = 0; i < L; i++){
				l_map[row+1+i] = true;
			}
			//2-2-3. ���θ� �� ���� ���� ���� ���� ��ġ�� ������
				//���� �ٳ������� ���� ��ġ�� ������
			if(row+L < map[0].length){
				col_dfs(row+L, col);
			}

		//2-3. ������ ���̰� -1�̸� ���� ��ġ�� 1 �� ���� ��
		}else if(map[row][col] - map[row+1][col] == -1){
			//�����ؾߴ�
			//1. ���� ���� �ڸ��� �ִ��� �Ǵ��ؾߴ�
			//	1.1 ���� ���� ���� ������ �ִ°�? 
			if(row-L+1 < 0){ 
				//System.out.println("����1-1");
				return; 
			}else{
				// �ڸ��� �Ǵ°� Ȯ������ �׷� ���� �������� Ȯ��
				double loadCheck = 0;
				for(int i = 0; i < L; i++){
					loadCheck += map[row-i][col]; 
				}
				// �� ���� ���� ���� �ڸ��� ����ġ �ʴٴ� �� return�ϰ� ���� col ����
				if(map[row][col] != (loadCheck/L)) {
					//System.out.println("����1-2");
					return;
				}
			}
			//2-2-2. ���θ� ���´�	//���� ��ġ �������ٰ� L���̸�ŭ ���´�
			//�̹� �����ϸ� ����
			for(int i = 0; i < L; i++){
				if(!l_map[row-i]){
				l_map[row-i] = true;
				}else {
					//System.out.println("����1-3");
					return;
				}
			}
			
			//���θ� ���� ���� ��ġ���� �������� �̵�
			col_dfs(row+1, col);
			//�Ȱ����� �������� �̵�
		}else if(map[row][col] - map[row+1][col] == 0){
			col_dfs(row+1, col);
		}
			
	}

}
