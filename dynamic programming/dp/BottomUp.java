package di;

public class BottomUp {
	/**
	 * 
	 * ���� �������� ū ������
	 * 
	 */
	int d[] = new int[100];
	int finonacci(int n) {
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= n; i++){
			d[i] = d[i-1] + d[i-2];
		}
		return d[n];
	}
}
