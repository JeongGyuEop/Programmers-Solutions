package 개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
    	// 문제에서 주어진 값
    	// 오늘 날짜
        String today = "2020.01.01";
        // 약관 정보: 약관의 종류와 유효기간(개월 수)로 구성된 배열 선언 및 초기화
        String[] terms = {"Z 3", "D 5"};
        // 개인 정보 수집 일자와 약관 종류로 구성된 배열 선언 및 초기화
        String[] privacies = {
            "2019.01.01 D", 
            "2019.11.15 Z", 
            "2019.08.02 D", 
            "2019.07.01 D", 
            "2018.12.28 Z"
        };
        
        // 유효기간이 지난 개인 정보 번호를 반환하는 solution 함수 호출
        ArrayList<Integer> result = solution(today, terms, privacies);
        // 결과 출력
        System.out.println(result); 
    }

    private static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
    	// 약관의 유효기간을 저장하는 HashMap 선언
        HashMap<String, Integer> map = new HashMap<>();
        // 유효기간이 지난 개인정보의 번호를 저장할 ArrayList 선언
        ArrayList<Integer> result = new ArrayList<>();
        
        // 약관 배열(terms)를 순회
        for(String str : terms) {
        	// 순회를 하며 가져온 값이 저장되어 있는 str 문자열을
        	// 공백으로 구분하여 termArr 배열에 저장
            String[] termArr = str.split(" ");
            // 약관 종류를 key로, 유효기간(개월 수)를 value로 저장
            map.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        
        // 오늘 날짜를 정수형으로 변환 (YYYYMMDD)
        int todayNum = Integer.parseInt(today.replace(".", ""));
        
        
        for(int i = 0; i < privacies.length; i++) {
        	// 개인정보 수집 일자와 약관 종류를 분리
            String[] privaciesMap = privacies[i].split(" ");
            // 수집 일자를 연도, 월, 일로 분리
            String[] dateAll = privaciesMap[0].split("\\.");
            
            // 연도, 월, 일 각각을 정수로 변환
            int year = Integer.parseInt(dateAll[0]);
            int month = Integer.parseInt(dateAll[1]);
            int day = Integer.parseInt(dateAll[2]);
            
            // 일(day)을 하루 감소시킴
            day--;  
            if(day == 0) {// 만약 감소된 결과가 0일 경우,
            	// 전월의 마지막 날인 28일로 설정
                day = 28;  
                // 월도 하나 감소
                month--;
            }
            
            // 약관의 유효기간을 월(month)에 추가
            month += map.get(privaciesMap[1]); 
         // 만약 월이 12를 초과하면
            if(month > 12) {
                year += month / 12; // 초과된 월을 연도로 변환
                month = month % 12; // 월을 12 이하로 조정
                if (month == 0) { // 월이 0이 되는 경우는 12월로 조정하고, 연도를 하나 감소
                    month = 12;
                    year--;
                }
            }
            
            // 계산된 유효기간의 연도, 월, 일을 YYYYMMDD 형식의 문자열로 변환
            String formattedDate = String.format("%04d%02d%02d", year, month, day);
            // 비교를 위해 정수형으로 변환
            int numB = Integer.parseInt(formattedDate);
            
            // 오늘 날짜와 계산된 유효기간을 비교하여, 유효기간이 지난 경우 해당 번호를 result 리스트에 추가
            if(todayNum > numB) {
                result.add(i + 1);
            }
        }
        // 유효기간이 지난 개인정보 번호들이 담긴 리스트 반환
        return result;
    }
}
