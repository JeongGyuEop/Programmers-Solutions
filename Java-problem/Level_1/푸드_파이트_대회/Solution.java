package 푸드_파이트_대회;

public class Solution {

	public static void main(String[] args) {
		
		// 문제에서 주어진 예시 food 배열
		int[] food = {1, 3, 4, 6};
		
		// solution 함수 호출 및 결과 저장
		StringBuilder result = solution(food);
		
		// 결과 출력
		System.out.println(result);
	}
	
	// 주어진 food 배열을 사용하여 음식을 대칭적으로 배치하는 함수
	public static StringBuilder solution(int[] food) {
		// 결과를 저장하는 StringBuilder
        StringBuilder answer = new StringBuilder();
        
        // 왼쪽에 음식을 배치(각 음식의 절반을 배치한다.)
        for(int i=1; i<food.length; i++) {
        	// 양쪽의 대친을 위해 음식 개수의 절반만큼 배치한다.
        	for(int j=0; j<(food[i]/2); j++) {
        		// 음식을 i번 answer에 추가한다.
        		answer.append(i);
        	}
        }
        
        // 가운데에 물(0)을 배치한다.
        answer.append(0);
        
        // 오른쪽에 음식을 대칭으로 배치한다.(왼쪽의 음식들을 역순으로 배치)
        for(int i=food.length - 1; i>=1; i--) {
        	// 음식 개수의 절반을 다시 역순으로 배치
        	for(int j=0; j<(food[i]/2); j++) {
        		// 음식 i번을 다시 추가한다.(대칭으로 배치)
        		answer.append(i);
        	}
        }
        
        // 최종 문자열 반환
        return answer;
    }

}
