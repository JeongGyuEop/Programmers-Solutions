package 기사단원의_무기;

public class Main {

	public static void main(String[] args) {
		// 문제에서 예시로 주어진
		// 기사단원의 수
		int number = 5;
		// 제한값
		int limit = 3;
		// 대체 무게 값
		int power = 2;
		
		// solution 함수 호출 후 결과를 result에 저장
		int result = solution(number, limit, power);
		
		// 결과 출력
		System.out.println(result);
		
	}
	
	// 각 기사단원의 철의 무게를 계산하는 함수
	public static int solution(int number, int limit, int power) {
        int answer = 0; // 철의 무게
        
        // 각 기사단원의 무기 철의 무게를 저장하는 배열
        int[] weapon = new int[number];
        
        // i값의 약수를 구하기 위해 제곱근까지 반복한다.
		for(int i=1; i<=number; i++) {
			// 약수 개수를 세기 위한 변수
			int count = 0;
					
			// i의 약수를 구하기 위해 제곱근까지 반복
			for(int j=1; j*j<=i; j++) {
				// j가 약수인 경우 카운트
				if(i % j == 0) {
					count++;
					if(j != i/j) { // 짝을 이루는 약수도 카운트
						count++;
					}
				} 
			}
			
			// 구한 약수의 개수를 weapon 배열에 저장
			weapon[i-1] = count;
		}
		
		// 각 기사단원의 무기의 철 무게 계산
		for(int i=0; i<number; i++) {
			// 약수의 개수가 limit을 넘으면 power만큼의 무게로 변경
			if(weapon[i] > limit) {
				answer += power;
			} else { // 그렇지 않으면 약수 개수만큼 철의 무게로 계산
				answer += weapon[i];
			}
		}
		// 최종 철의 무게 반환
        return answer;
    }

}
