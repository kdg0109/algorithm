import java.util.ArrayList;
import java.util.Scanner;

/*
	입력
	첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
	
	둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
	
	출력
	첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
*/

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
 */

class Work {
	private int Ti = 0; //일의 기간
	private int Pi = 0; //일의 보수
	
	public Work(int ti, int pi) {
		super();
		Ti = ti;
		Pi = pi;
	}
	public int getTi() {
		return Ti;
	}
	public void setTi(int ti) {
		Ti = ti;
	}
	public int getPi() {
		return Pi;
	}
	public void setPi(int pi) {
		Pi = pi;
	}
}

public class main {
	static Scanner sc;
	static int N = 0;	//남은 근무 일수
	static int maxP = 0; //최고 보상 액수
	
	static ArrayList<Work> arraylist = new ArrayList<Work>();
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i = 0; N > i; i++){
			arraylist.add(new Work(sc.nextInt(), sc.nextInt()));
		}

		startWork(0, 0);
		System.out.println(maxP);
		
		
	}
	
	public static int startWork(int defaultPos, int defaultPay){
//		System.out.println("일을 시작하자. 현재  날짜 위치는 " +defaultPos+"이고 번 돈은 " + defaultPay);
		int pay = defaultPay;
		
		for(int pos = defaultPos; N > pos; pos++){
			pay = defaultPay;
			
			//더 일을 할 수있을 때 들어감
			if((N >= arraylist.get(pos).getTi() + pos)){
				pay = startWork(pos + arraylist.get(pos).getTi(), pay + arraylist.get(pos).getPi());

//				System.out.println("한 패턴에서 번 돈 : "+ pay);
				//일을 다 끝마치고 왔을 때임. 그말은 한 패턴에서 돈 다 벌었을때
				
				if(maxP < pay){
					maxP = pay;
				}
			}
		}
		

		
		
//		System.out.println("============= 현재 패턴 종료 ===========");
		//한 패턴에서 일을 다 끝냈을 때
		return pay;
	}
}
