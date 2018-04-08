package samsung01;

import java.io.InputStream;
import java.util.Scanner;

public class samsung05 {
	static int N = 0;		//����
	static int M = 0; 		//����
	static int r = 0;	//�κ� û�ұ� ���� ��ġ ��
	static int c = 0;	//�κ� û�ұ� ���� ��ġ ��
	static int d = 0;	//�κ� û�ұ� ����
	
	final static int NN = 0;	//����
	final static int EE = 1;	//����
	final static int SS = 2;	//����
	final static int WW = 3;	//����
	
	static int map[][] = null;			//��
	
	static boolean visited[][] = null;	//�湮����
	static int clear = 0;			//û���� ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		//�κ� ������ �ʱ�ȭ

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
	//rotate_cnt�� ȸ�� Ƚ���̰� ������ 4��°�̸� �ƹ��͵� ���ٴ� ��
	//rotate�� false�� �̵��ѰŰ� true�� �ܼ� ȸ��
	static void dfs(int row, int col, boolean rotate, int rotate_cnt){
		if(rotate_cnt == 9999){
			System.out.println(clear);
			System.exit(0);
		}
		////System.out.println(rotate_cnt);
		//System.out.println(row + "," + col);
		int cnt = rotate_cnt;
		//�����ϸ� û���Ѵ� 
		if(cnt == 0 && !rotate){
			map[row][col] = 2;
			clear++;
		}
		
		////System.out.println(rotate_cnt +" / " + cnt);
		////System.out.println("���� ��ġ : " + row + "/"+ col + "�̰� ���� ���� " + d);
		if(cnt < 4){
			//ȸ���Ѵ�
			d = directionSetting(d);
		}
		////System.out.println(d + "�� �� ������.");
		//System.out.println(cnt+"/"+d);
		//������ ��������
		//������ û���ؾ��Ѵٸ�, �������� ���� (�� �������� ��ǥ�̵���) dfs
		if(d == NN){
			////System.out.println("�ٶ󺸴� ���� N");
			if(cnt == 4){
				if(map[row-1][col] == 0){
					////System.out.println("4�������� " + (row-1)+"/"+col + "�� �����δ�.");
					dfs(row-1, col, false, 0);
				}else{
					if(map[row+1][col] == 0){
						////System.out.println("4�������� " + (row-1)+"/"+col + "�� �����δ�.");
						dfs(row+1, col, false, 0);
					}else if(map[row+1][col] == 2){
						////System.out.println("4�������� " + (row-1)+"/"+col + "�� �����δ�.");
						dfs(row+1, col, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row-1][col] == 0){	//�����Ѱ�
				////System.out.println("4�������� " + (row-1)+"/"+col + "�� �����δ�.");
				//�̵�
				dfs(row-1, col, false, 0);
			}else{
				////System.out.println("a ȸ��");
				dfs(row, col, true, cnt+1);	//ȸ����
			}
		}else if(d == EE){
			////System.out.println("�ٶ󺸴� ���� E");
			if(cnt == 4){
				if(map[row][col+1] == 0){
					////System.out.println("4�������� " + row+"/"+(col+1) + "�� �����δ�.");
					dfs(row, col+1, false, 0);
				}else{
					if(map[row][col-1] == 0){
						dfs(row, col-1, false, 0);
					}else if(map[row][col-1] == 2){
						////System.out.println("4�������� " + (row-1)+"/"+col + "�� �����δ�.");
						dfs(row, col-1, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row][col+1] == 0){	//�����Ѱ�
				////System.out.println(row+"/"+(col+1) + "�� �����δ�.");
				//�̵�
				dfs(row, col+1, false, 0);
			}else{
				////System.out.println("b ȸ��");
				dfs(row, col, true, cnt+1);	//ȸ����
			}
		}else if(d == SS){
			////System.out.println("�ٶ󺸴� ���� S");
			if(cnt == 4){
				if(map[row+1][col] == 0){	//�����Ѱ�
					//�̵�
					////System.out.println("4�������� " + (row+1)+"/"+col + "�� �����δ�.");
					dfs(row+1, col, false, 0);
				}else{
					if(map[row-1][col] == 0){
						dfs(row-1, col, false, 0);
					}else if(map[row-1][col] == 2){
						////System.out.println("4�������� " + (row-1)+"/"+col + "�� �����δ�.");
						dfs(row-1, col, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row+1][col] == 0){	//�����Ѱ�
				////System.out.println((row+1)+"/"+col + "�� �����δ�.");
				//�̵�
				dfs(row+1, col, false, 0);
			}else{
				////System.out.println("c ȸ��");
				dfs(row, col, true, cnt+1);	//ȸ����
			}
		}else if(d == WW){
			////System.out.println("�ٶ󺸴� ���� W");
			if(cnt == 4){
				if(map[row][col-1] == 0){	//�����Ѱ�
					////System.out.println("4�������� " + row+"/"+(col-1) + "�� �����δ�.");
					//�̵�
					dfs(row, col-1, false, 0);
				}else{
					if(map[row][col+1] == 0){
						dfs(row, col+1, false, 0);
					}else if(map[row][col+1] == 2){
						////System.out.println("4�������� " + (row-1)+"/"+col + "�� �����δ�.");
						dfs(row, col+1, true, 0);
					}else{
						dfs(row, col, false, 9999);
					}
				}
			}else if(map[row][col-1] == 0){	//�����Ѱ�
				////System.out.println("4�������� " + row+"/"+(col-1) + "�� �����δ�.");
				//�̵�
				dfs(row, col-1, false, 0);
			}else{
				////System.out.println("d ȸ��");
				dfs(row, col, true, cnt+1);	//ȸ����
			}
		}
		//���� û���Ұ� ������ �������� ���� 						dfs
	}
}