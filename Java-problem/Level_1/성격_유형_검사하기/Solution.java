package 성격_유형_검사하기;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {

		// 문제에서 주어진 테스트 데이터 
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		// solution 함수 호출 후 결과 반환
		String result = solution(survey, choices);
		
		// 결과 출력
		System.out.println(result);

	}
	
	// 성격 유형 검사 결과를 반환하는 함수
	public static String solution(String[] survey, int[] choices) {
        
		// 성격 유형 종류를 배열로 저장
        String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};
        
        // 선택지에 따른 점수 매핑
        HashMap<Integer, Integer> mapScore = new HashMap<Integer, Integer>();
        
        // 각 성격 유형의 종류를 배열로 저장
        HashMap<String, Integer> mapResult = new HashMap<String, Integer>();
        
        // 선택지 번호만큼 순회하며 선택지에 따라 점수를 매핑
        for(int i=1; i<8; i++) {
        	int val = Math.abs(4-i); // 중심 값 4에서의 거리만큼 점수로 계산(절댓값)
        	mapScore.put(i, val);
        }
        
        // 각 성격 유형의 점수를 초기화한다.(초기값 0)
        for(int i=0; i<type.length; i++) {
        	mapResult.put(type[i], 0);
        }
        
        // 각 질문에 대해 점수를 계산하여 mapResult에 반영한다.
        for(int i=0; i<survey.length; i++) {
        	// 현재 질문의 성격 유형을 분리
        	String[] arr = survey[i].split("");
        	
        	// 비동의 선택지를 선택한 경우
        	if(choices[i] < 4) {
        		mapResult.put(arr[0], mapResult.get(arr[0]) + mapScore.get(choices[i]));
        	} else  if (choices[i] > 4){ // 동의 선택지를 선택한 경우
        		mapResult.put(arr[1], mapResult.get(arr[1]) + mapScore.get(choices[i]));
        	}
        }
        
        // 각 지표에 따른 성격 유형을 선택한다.
        StringBuilder result = new StringBuilder();
        result.append(mapResult.get("R") >= mapResult.get("T") ? "R" : "T");
        result.append(mapResult.get("C") >= mapResult.get("F") ? "C" : "F");
        result.append(mapResult.get("J") >= mapResult.get("M") ? "J" : "M");
        result.append(mapResult.get("A") >= mapResult.get("N") ? "A" : "N");
        
        // 최종 결과 반환
        return result.toString();
    }

}
