import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // HashMap 생성
        HashMap<String, Integer> studentScores = new HashMap<>();

        // 데이터 추가 (키: 학생 이름, 값: 점수)
        studentScores.put("홍길동", 85);
        studentScores.put("이순신", 90);
        studentScores.put("강감찬", 95);

        // HashMap 출력
        System.out.println("학생 점수 목록: " + studentScores);

        // 특정 키(학생 이름)로 값(점수) 조회
        String studentName = "이순신";
        if (studentScores.containsKey(studentName)) {
            int score = studentScores.get(studentName);
            System.out.println(studentName + "의 점수: " + score);
        } else {
            System.out.println(studentName + "의 점수를 찾을 수 없습니다.");
        }

        // 모든 키-값 쌍을 순회
        System.out.println("\n모든 학생들의 점수: ");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() +" : " + entry.getValue());
        }

        // 값 수정
        studentScores.put("홍길동", 88);
        System.out.println("\n홍길동의 새로운 점수: " + studentScores.get("홍길동"));

        // 키-값 쌍 삭제
        studentScores.remove("강감찬");
        System.out.println("\n강감찬의 정보를 삭제한 후: " + studentScores);

        // HashMap의 크기 확인
        System.out.println("\n현재 학생 수: " + studentScores.size());
    }


}