package 옹알이_2;

public class Solution {

	public static void main(String[] args) {
		// 테스트 데이터
		String[] babbling = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
		
		// solution 함수 호출 및 결과 출력
		int result = solution(babbling);
		System.out.println(result);

	}

	// 발음할 수 있는 단어의 개수를 반환한다.
	public static int solution(String[] babbling) {
		// 발음할 수 있는 단어의 개수를 저장할 변수 초기화
        int answer = 0;
        
        // 발음할 수 있는 단어 목록
        String[] possible = {"aya", "ye", "woo", "ma"};
        
        // 주어진 단어의 배열을 순회하며 word 변수에 넣는다.
        for(String word : babbling) {
        	
        	//해당 단어가 발음이 가능한지의 여부를 저장하는 변수를 ture로 초기화
        	boolean isPossible = true;
        	
        	// 발음할 수 있는 단어 목록 배열을 순회하며 sound변수에 저장
        	// 연속된 발음이 있는지 확인한다.
        	for(String sound : possible) {
        		// 같은 발음이 연속으로 두 번 나타난다면
        		if(word.contains(sound.repeat(2))) {
        			isPossible = false; // 발음 불가능
        			break; // 더이상 확인할 필요가 없기 때문에 순회 종료
        		}
        	}
        	
        	// 연속된 발음이 없다면
        	if(isPossible) {
        		// 발음할 수 있는 단어 목록 배열을 순회하며 sound 변수에 저장한다.
        		for(String sound : possible) {
        			word = word.replace(sound, ""); // 가능한 발음을 모두 제거한다
        											// 발음을 찾아서 빈 문자열로 대체한다.
        		}
        		
        		// 남은문자열이 빈 문자열이면 발음 가능한 단어로 간주한다.
        		if(word.trim().isEmpty()) {
        			answer++; // 발음할 수 있는 단어 개수를 증가한다.
        		}
        	}
        }
        
        // 발음할 수 있는 단어의 총 개수를 반환한다.
        return answer;
    }
}
