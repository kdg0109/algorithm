package di;

public class TopDown {
/**
 * 
 * �޸� ����.
 * memo[n] = n��° �Ǻ���ġ ��
 * ū �������� ���� ������
 * 
 */
	//�ʱⰡ 0��
	//�ٵ� ���� 0�� �����ϴ� �� ��, -1�� �ʱⰪ�ؾ���
	int memo[] = new int[100];
	
	int fibonacci(int n) {
		if(n <= 1) {
			return n;
		} else {
			// 0�� 1�� �̹� �տ� if���� ó����. �׷��� 0���� Ŭ ��
			if(memo[n] > 0){
				return memo[0];
			}
			memo[n] = fibonacci(n-1) + fibonacci(n-2);
			return memo[n];
		}
	}

}
