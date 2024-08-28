package src;

import java.util.HashSet;
import java.util.Set;

public class PasswordOfUs {
    public static void main(String[] args){
        // 변환할 문자열 s
        String s = "aukks";
        // 건너뛸 문자들을 포함한 문자열 skip
        String skip = "wbqd";
        // 이동할 인덱스 값 index
        int index = 5;

        // solution 메소드를 호출하여 결과를 얻고 출력
        String result = solution(s, skip, index);
        System.out.println(result); // "happy" 출력
    }

    // 주어진 규칙에 따라 문자열을 변환하는 메서드
    public static String solution(String s, String skip, int index) {
        // 문자열을 효율적으로 조합하기 위해 StringBuilder를 사용하여 sb 선언
        StringBuilder sb = new StringBuilder();
        // skip 문자열에 포함된 각 문자를 Set에 추가
        Set<Character> skipSet = new HashSet<>();
        // 향상된 for문을 사용하여 skip문자열에 포함된 각 문자를 Set에 추가한다.
        for(char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }
        // 향상된 for문을 사용하여 s 문자열의 각 문자에 대해 순회하고 각 값을 ch 변수에 저장한다.
        for (char ch : s.toCharArray()) {
            // 이동한 문자 수를기록하는 변수
            int count = 0;
            // index 값만큼 문자를 이동시키면서 skip 문자는 건너뛴다
            while(count < index) {
                //문자를 다음 문자로 이동
                ch++;
                if(ch > 'z') { // ch 값이 'z'보다 크다면 'z'다음의 알파벳은 없으므로
                    ch = 'a'; // 알파벳의 처음인 'a'값을 대입
                }
                // 현재 문자가 skipSet에 포함되지 않은 경우 count 증가
                if(!skipSet.contains(ch)) {
                    count++;
                }
            }

            // 변환된 문자를 StringBuilder에 추가한다.
            sb.append(ch);
        }
        // 최종 변환된 문자열 반환
        return sb.toString();
    }
}
