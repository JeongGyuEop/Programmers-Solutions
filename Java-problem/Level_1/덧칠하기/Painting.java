package 덧칠하기;

public class Painting {
    public static void main(String[] args) {
        int n = 8; // 문제에서 주어진 벽의 크기
        int m = 4; // 페인트를 한 번 칠할 때 칠할 수 있는 크기
        int[] section = {2, 3, 6}; // 색을 칠해야하는 구역

        // n, m, section을 매개변수로 하여 solution 함수 호출
        int result = solution(n, m, section);

        // 결과 출력
        System.out.println(result);
    }

    public static int solution(int n, int m, int[] section) {
        int count = 0; // 페인트를 칠하는 횟수
        int lastPainted = 0; // 마지막으로 칠해진 구역의 끝 번호

        for (int start : section) { // section 배열을 순회하며 각 구역을 검사한다.
            if(start > lastPainted) { // 새로 칠해야하는 부분이 마지막으로 칠해진 구역보다 크다면
                // 새로운 페인트칠이 필요하다.
                count++; // 페인트칠 횟수 증가

                lastPainted = start + m - 1; // 마지막으로 칠한 구역 번호 업데이트
            }
        }
        return count;
    }
}
