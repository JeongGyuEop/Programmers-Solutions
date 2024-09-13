package 문자열_나누기;

public class Solution {
	public static void main(String[] args) {
		String s = "banana";
		
		int result = solution(s);
		
		System.out.println(result);
		
	}

	public static int solution(String s) {
		// 문자열이 나누어질 때마다 카운트하는 변
		int answer = 0;
		
		int x = s.charAt(0); // 첫 번째 문자를 기준 문자로 하여 x변수에 저장
		int diff = 0; // 기준 문자와 다른 문자의 수를 카운트 하는 변수
		int same = 0; // 기준 문자와 같은 문자의 수를 카운트 하는 변
		
		// 문자열의 각 문자를 순
		for(int i=0; i<s.length(); i++) {
			if(x == s.charAt(i)) { // 순회를 하며 기준 문자와 동일한 문자가 나타나면
				same += 1; // same 변수 1 증가
			} else { // 기준문자와 다른 문자가 나타나면
				diff += 1; // diff 변수 1 증가
			}
			
			if(same == diff) { // 기준 문자와 동일한 문자의 개수와 다른 문자의 개수가 같아지면
				answer += 1; // 하나의 부분문자열로 나눔과 동시에 카운트 증가
				diff = 0; // diff 초기화
				same = 0; // same 초기화
				
				if (i + 1 < s.length()) { // 배열 범위를 넘지 않도록
                    x = s.charAt(i + 1); // 다음 기준 문자 설정
                }
			}
			
		}
		
		// 나누고 남은 부분도 하나의 그룹으로 처리
        if (same != 0 || diff != 0) {
            answer += 1;
        }
		
		return answer; // 최종적으로 나누어진 부분 문자열 개수를 반

	}

}
