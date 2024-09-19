package 과일_장수;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// 문제에서 주어진 테스트 케이스로 설정된 값
		int k = 3; // 점수의 최대값
		int m = 4; // 한 상자에 들어가는 사과의 개수
		int[] score = {1, 2, 3, 1, 2, 3, 1}; // 사과 점수 배열
		
		// solution 함수 호출 후 결과 출력
		int result = solution(k, m, score);

		// 결과 출력
		System.out.println(result);
	}

	// 사과를 상자 단위로 포장하여 최대 이익을 계산하는 함수
	public static int solution(int k, int m, int[] score) {
		// 최종 결과 값을 저장할 변수
        int answer = 0;
        
        // 매개변수로 전달받은 점수 배열을 오름차순으로 정렬
        Arrays.sort(score);
        
        // 반복문을 순회하면서 배열을 뒤에서부터 m개씩 묶어서 계산한다.
        for (int i = score.length - m; i >= 0; i -= m) {
        	// 상자 크기 m만큼 나눈 위치의 score[i] 를 가져와 가격을 계산하고,
        	// answer에 누적한다.
            answer += score[i] * m;
        }
        
        // 최종 결과 반환
        return answer;
        
    }
}
