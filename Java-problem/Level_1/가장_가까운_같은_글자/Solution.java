package 가장_가까운_같은_글자;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// 문제에서 주어진 예시 문자열 s
		String s = "banana";
		
		// solution 함수 호출 후 결과를 result 배열에 저장
		int[] result = solution(s);

		// 결과 출력
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution(String s) {
		// 문자열 s와 같은 크기의 정수 배열을 생성
        int[] answer = new int[s.length()];
        // 각 문자의 마지막 인덱스를 저장할 HashMap 생성
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 문자열 s의 크기만큼 각 문자를 순회
        for(int i=0; i<s.length(); i++) {
        	// 현재 문자를 str 변수에 저장
        	char str = s.charAt(i);
        	// 만약 HashMap에 현재 문자가 저장되어 있지 않다면(처음 등장하는 문자일 경우)
        	if(!map.containsKey(str)) {
        		// 해당 문자를 키(key)로, 인덱스를 값(value)으로 map에 저장
        		map.put(str, i);
        		// 결과값을 저장하는 answer 배열의 해당 인덱스에 -1 저장
        		answer[i] = -1;
        	} else { // HashMap에 현재 문자가 저장되어 있다면
        		// 현재 인덱스와 map에 저장되어 있는 해당 문자의 이전 인덱스와의 차이를
        		// 계산하여 num 변수에 저장
        		int num = i - map.get(str);
        		// map에 현재 문자의 인덱스 업데이트
        		map.put(str, i);
        		// 계산된 차이를 결과를 반환하는 answer 배열에 저장
        		answer[i] = num;
        	}
        }
        
        // 결과 배열 반환
        return answer;
    }
}
