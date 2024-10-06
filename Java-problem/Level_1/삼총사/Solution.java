package 삼총사;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// 학생들의 번호를 저장하는 배열(문제에서 주어진)
		int[] number = {-2, 3, 0, 2, -5};
	
		int result = solution(number); // solution 함수 호출하여 결과를 저장
		System.out.println(result); // 결과 출력
		
	}
	
	public static int solution(int[] number) {
		
		List<int[]> combinations = new ArrayList<>(); // 조합을 저장할 리스트
		
		// 세 명의 학생을 선택하는 조합을 구한다.
		combination(number, 3, 0, new int[3], combinations);
		
		int count = 0; // 삼총사의 수를 세기 위한 변수
		
		// 각 조합에 대해 세 학생의 번호 합이 0인지 확인
		for(int[] comb : combinations) {
			if(comb[0] + comb[1] + comb[2] == 0) {
				count++; // 합이 0이면 삼총사 수 증가
			}
		}
		
		return count; // 삼총사의 수 변환
		
	}
	
	// 조합을 구하는 재귀 함수
	// arr : 원본 배열
	// r : 선택할 학생 
	// index : 배열에서 현재 위치
	// comb : 선택된 학생 배열
	// combinations : 모든 조합을 저장할 리스트
	public static void combination(int[] arr, int r, int index, int[] comb, List<int[]> combinations) {
		if( r == 0 ) {
			// r이 0이 되면 조합이 완성됨 (3명의 학생이 선택됨)
			combinations.add(comb.clone()); // 현재 조합을 리스트에 추가
			return; // 함수 종료
		}
		
		if( index == arr.length) {
			// 배열의 끝까지 탐색을 마친 경우 더 이상 선택할 학생이 없으므로 종료
			return;
		}
		
		// 현재 배열의 index 위치에 있는 원소를 선택하는 경우
		comb[comb.length - r] = arr[index]; // 선택된 원소를 comb 배열에 저장
		
		// 재귀 호출, r을 1줄이고 다음 위치 탐색
		combination(arr, r - 1, index + 1, comb, combinations);
		
		// 현재 배열의 index 위치에 있는 원소를 선택하지 않는 경우
		combination(arr, r, index + 1, comb, combinations); // 선택하지 않고 다음 위치 탐색
 		
	}

}



























