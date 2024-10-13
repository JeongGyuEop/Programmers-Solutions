package 숫자_짝궁;

public class Solution {

	public static void main(String[] args) {

		String X = "12321"; // 문제에서 주어진 문자열 X 초기화
		String Y = "42531"; // 문제에서 주어진 문자열 Y 초기화
		
		// solution 메소드 호출하여 결과를 result변수에 저장
		String result = solution(X, Y); 

		// 결과 출력
		System.out.println(result);
	}

	public static String solution(String X, String Y) {
		// 두 문자열의 각 숫자의 빈도를 저장할 배열 (0부터 9까지)
        int[] countX = new int[10]; // X에서의 숫자 빈도
        int[] countY = new int[10]; // Y에서의 숫자 빈도
        
        // X 의 각 문자를 순회하며 해당 숫자의 빈도 증가
        for(int i=0; i<X.length(); i++ ) {
        	// '0'을 빼는 이유 : X.charAt(i)는 char 값을 반환한다.
        	// 그렇기 때문에 ''5'라는 문자는 유니코드 값으로 53이므로,
        	// '0'(유니코드 값 48)을 빼면 실제 숫자 5로 변환된다.
        	countX[X.charAt(i) - '0']++; 
        }
        
        // Y 의 각 문자를 순회하며 해당 숫자의 빈도 증가
        for(int i=0; i<Y.length(); i++ ) {
        	// 위의 설명과 마찬가지다.
        	countY[Y.charAt(i) - '0']++;
        }
        
        // 공통 숫자를 저장하기 위해 StringBuilder 선언
        StringBuilder sb = new StringBuilder();
        
        // 큰 숫자(9)부터 작은 숫자(0)으로 순차적으로 공통 숫자를 증가한다.
        for(int i=9; i>=0; i--) {
        	// X와 Y에서 해당 숫자의 공통 빈도중 작은 값을 선택하여 저장한다.
        	int commonCount = Math.min(countX[i], countY[i]);
        	for(int j=0; j<commonCount; j++) { // 적은 빈도수 만큼 순회
        		sb.append(i); // 공통으로 등장한 숫자를 그 개수만큼 결과에 추가한다. 
        	}
        }
        
        if(sb.length() == 0) { // 공통 숫자가 없다면
        	return "-1"; // -1 반환
        }
        
        if(sb.toString().startsWith("0")) { // 결과가 0으로만 이루어져 있으면
        	return "0"; // 0 반환
        }
        
        // 공통 숫자로 만든 가장 큰 수 반환
        return sb.toString();
    }
}
