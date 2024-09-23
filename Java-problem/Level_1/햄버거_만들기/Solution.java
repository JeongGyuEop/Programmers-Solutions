package 햄버거_만들기;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) { 
	
		// 문제에서 주어진 테스트 배열 
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient)); // 출력: 2

		
	}
	
	// 햄버거를 만들 수 있는 개수를 구하는 함수
	public static int solution(int[] ingredient) {
		int answer = 0; // 완성된 햄버거의 개수를 저장할 변수
		
		// 재료를 저장할 스택
		Stack<Integer> stack = new Stack<>();
		
		// 향상된 for문을 사용하여 주어진 재료 배열을 순회하며 순차적으로 처리한다.
		for(int i : ingredient) {
			
			// 현재 재료를 스택에 추가한다.
			stack.push(i);
			
			// 만약 스택에 4개 이상의 재료가 쌓인다면
			if(stack.size() >= 4) {
				int size = stack.size(); // 현재 스택의 크기를 확인
				
				// 마지막 4개의 재료가 1(빵) - 2(야채) - 3(고기) - 1(빵)의 순서라면
				if( stack.get(size - 4) == 1 && stack.get(size - 3) == 2 &&
				    stack.get(size - 2) == 3 && stack.get(size - 1) == 1 ) {
					
					// 만족하는 4개의 재료를 스택에서 제거한다.
					for(int j=0; j<4; j++) {
						stack.pop(); // 스택에서 재료 제거
					}
					
					answer++; // 하나의 햄버거를 완성하여 카운트 증가
				}
			}
		}
		
		return answer; // 완성된 햄버거의 개수를 반환한다.
	}
	
}