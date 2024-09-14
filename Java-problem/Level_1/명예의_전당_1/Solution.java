package 명예의_전당_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {
		// 명예의 전당 크기를 나타내는 k 정수 변수 초기화
		int k = 3;
		// 점수의 배열을 나타내는 score 정수 배열 정의
		int[] score = {10, 100, 20, 150, 1, 100, 200};
		// solution 함수 호출 후 반환받은 결과를 저장하는 result 배열 선언
		int[] result = solution(k, score);
		
		// 결과 출력
		System.out.println(Arrays.toString(result));

	}
	
	// 문제에서 주어진 k와 score 배열을 기반으로 명예의 전당에서 가장 작은 값을 매 순간 추적하는 함수
	public static int[] solution(int k, int[] score) {
		// 결과를 저장할 배열을 score 점수 배열과 같은 길이로 초기화
        int[] answer = new int[score.length];
        // 명예의 전당을 나타내는 ArrayList 생성
        ArrayList<Integer> legend = new ArrayList<Integer>();
        
        // 점수 배열을 순회
        for(int i=0; i<score.length; i++) {
        	// 현재 점수를 전당에 추가
        	legend.add(score[i]);
        	// 만약 전당의 크기가 k(문제에서 주어진 전당의 크기)를 초과하면
        	if(i >= k) {
        		// 전당에서의 최소값을 제
        		legend.remove(Integer.valueOf(Collections.min(legend)));
        	} 
        	
        	// 현재 명예의 전당에서 가장 작은 값으 answer 배열에 저
        	answer[i] = Collections.min(legend);
        	
        }
        
        // 결과 반환
        return answer;
    }

}
