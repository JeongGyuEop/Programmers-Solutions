package 콜라_문제;

public class Solution {

	public static void main(String[] args) {

		// 문제에서 주어진 테스트 예제
		int a = 3; // 콜라를 받기 위해 마트에 주어야 하는 병의 수
		int b = 1; // 빈 병 a개를 가져다 주졈 만트가 주는 콜라병의 수
		int n = 20; // 가지고 있는 빈 병의 개수
		
		// solution 함수 호출 및 결과 출력
		int result = solution(a, b, n);
		System.out.println(result);
		
	}
	
	// 빈 병을 사용하여 받을 수 있는 콜라 병의 총 갯수를 계산하는 함수
	public static int solution(int a, int b, int n) {
        int answer = 0; // 총 받은 콜라 병의 개수를 저장할 변수
        
        int quoti; // 빈 병으로 교환 가능한 콜라 병의 개수(몫)
        int remain; // 교환 후 남은 빈 병의 개수 (나머지)
        
        int amount = n; // 현재 가지고 있는 빈 병의 수
        
        // 빈 병을 계속 교환할 수 있을 때 까지 반복한다.
        while(true) {
        	
        	quoti = amount / a; // 빈 병으로 교환할 수 있는 콜라 병의 개수 계산(몫)
        	remain = amount % a; // 교환 후 남은 빈 병의 개수를 계산 (나머지)
        	
        	// 새로운 빈 병의 개수는 받은 콜라 병의 수 (b * quoti) + 남은 빈 병의 수(나머지)
        	amount = (quoti * b) + remain; 
        	
        	// 받은 콜라 병의 수를 총 합에 누적
        	answer += quoti * b;
        	
        	// 더이상 콜라를 교환할 수 없다면
        	if(amount < a) {
        		break; // 반복문을 종료한다.
        	}
        	
        }
        
        // 총 받은 콜라 병의 수를 반환한다.
        return answer;
    }

}
