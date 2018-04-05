package di;

public class TopDown {
/**
 * 
 * 메모를 쓴다.
 * memo[n] = n번째 피보나치 수
 * 큰 단위에서 작은 단위로
 * 
 */
	//초기가 0임
	//근데 만약 0도 존재하는 걸 땐, -1로 초기값해야함
	int memo[] = new int[100];
	
	int fibonacci(int n) {
		if(n <= 1) {
			return n;
		} else {
			// 0과 1은 이미 앞에 if에서 처리됨. 그래서 0보다 클 때
			if(memo[n] > 0){
				return memo[0];
			}
			memo[n] = fibonacci(n-1) + fibonacci(n-2);
			return memo[n];
		}
	}

}
