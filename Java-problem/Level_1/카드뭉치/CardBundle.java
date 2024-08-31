package 카드뭉치;

public class CardBundle {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String result = solution(cards1, cards2, goal);
        System.out.println(result);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        // 첫 번째 카드와 두 번째 카드에 대해 인덱스를 따로 관리해야하므로
        // 첫 번째 카드의 인덱스 위치를 저장할 index1변수 선언
        int index1 = 0;
        // 두 번째 카드의 인덱스 위치를 저장할 index2 변수를 선언
        int index2 = 0;

        // 목표 배열의 크기만큼 순회하면서 index 위치를 사용하여 첫 번째 카드와 두번째 카드에서
        // 목표 배열의 각 값에 대해 일치하는 값이 있는지 확인
        for(int i = 0; i < goal.length; i++) {
            // index1의 값이 첫 번째 카드의 크기보다 작으면서, 순회에서 해당하는 목표 배열의
            // 값과 첫 번째 카드에서의 인덱스 위치의 값이 일치한다면
            if(index1 < cards1.length && (goal[i].equals(cards1[index1]))) {
                index1++; // 다음 비교를 위해 index1 값을 1 증가

            } else if(index2 < cards2.length && (goal[i].equals(cards2[index2]))) {
                // index2의 값이 두 번째 카드의 크기보다 작으면서, 순회에서 해당하는 목표 배열의
                // 값과 두 번째 카드에서의 인덱스 위치의 값이 일치한다면

                index2++; // 다음 비교를 위해 index2 값을 1 증가
            } else { // 둘 중 무엇도 일치하지 않는다면
                // 문자열 "No"를 반환하고 함수 종료
                return "No";
            }
        }
        // 반복문을 무사히 통과하면 -> 모든 문자가 순차적으로 일치한다면
        return "Yes"; // "Yes"를 반환하고 함수 종료
    }
}
