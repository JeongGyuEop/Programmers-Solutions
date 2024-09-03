package 크기가_작은_부분_문자열;

public class Main {

	public static void main(String[] args) {

		String t = "3141592";
		String p = "271";
		
		int result = solution(t, p);
		System.out.println(result);

	}
	
	public static int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();  // p 문자열의 길이
        long pNumber = Long.parseLong(p);  // p를 정수로 변환
        
        // t에서 p의 길이만큼의 부분 문자열을 슬라이딩 윈도우 방식으로 비교
        for (int i = 0; i <= t.length() - pLength; i++) {
            String sub = t.substring(i, i + pLength);  // 부분 문자열 추출
            long subNumber = Long.parseLong(sub);  // 부분 문자열을 정수로 변환
            if (subNumber <= pNumber) {
                answer++;
            }
        }
		
		return answer;
	}

}
