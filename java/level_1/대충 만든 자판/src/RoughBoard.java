package src;

import java.util.Arrays;
import java.util.HashMap;

public class RoughBoard {
    public static void main(String[] args) {
        // 문제에서 주어진 1번 키부터 차례대로 할당된 문자들이 담긴 문자열 배열
        String[] keymap = {"AA"};
        // 문제에서 주어진 입력하려는 문자열들이 담긴 문자열 배열
        String[] targets = {"B"};

        // keymap과 targets를 solution 함수의 매개변수로 전달하여 반환 값을 result 변수에 저장
        int[] result = solution(keymap, targets);

        // 결과 출력
        System.out.println(Arrays.toString(result));

    }

    public static int[] solution(String[] keymap, String[] targets) {
        // 각 문자(Character)를 입력할 때 필요한 최소 키 입력 횟수를 저장하기 위한 HashMap 생성
        HashMap<Character, Integer> map = createKeymap(keymap);

        // 각 target 문자열에 대해 최소 키 입력 횟수를 계산하여 결과 배열을 생성하고 반환
        return calculateKeyPresses(targets, map);
    }

    /*
        keymap 배열을 분석하여 각 문자에 대한 최소 입력 횟수를 기록한 HashMap을 생성하는 함수

        @param : keymap 각 키에 할당된 문자가 들어 있는 배열
        @return : 각 문자의 최소 입력 횟수가 저장된 HashMap
     */
    private  static HashMap<Character, Integer> createKeymap(String[] keymap) {
        HashMap<Character, Integer> map = new HashMap<>();

        // keymap 배열을 순회하면서 각 키에 할당된 문자열을 확인한다.
        for(String key : keymap) {
            // 현재 문자열 (key)의 크기만큼 반복하면서 각 문자를 순서대로 확인
            for (int i = 0; i < key.length(); i++) {
                // key 문자열에서 현재 확인 중인 문자를 변수 ch에 저장
                char ch = key.charAt(i);
                // 현재 문자가 몇 번째 입력으로 생성되는지 계산
                int value = i + 1;

//                // 해당 문자가 map에 없거나, 현재 계산된 입력 횟수(value)가 기존에 기록된 횟수보다 작으면
//                if(!map.containsKey(ch) || map.get(ch) > value) {
//                    // 문자를 키로 하여 입력 횟수를 map에 저장하거나, 더 작은 값으로 업데이트
//                    map.put(ch, value);
//                }
                // 위의 코드의 map.containsKey()를 사용한다면 키가 존재하는지 확인한 다음에 값을 추가하거나 수정한다.
                // 더 좋은 방법으로 map.computeIfAbsent를 사용할 수 있는데, 이 메서드는 키가 존재하는 경우에만
                // 값을 계산하여 넣어주는 방식이다. 하지만 문제의 코드에서는 키가 존재할 뿐만 아니라 값의 크기도
                // 비교하여 저장해야 하므로 키가 존재하는 경우에만 값을 업데이트하는 Map.merge() 메서드를 사용하는
                // 방법이 더 효율적이다.

                // 수정한 코드
                map.merge(ch, value, Math::min);
            }
        }

        // 각 문자의 최소 입력 횟수를 저장한 HashMap 반환
        return map;
    }


    /*
        targets 배열에 있는 각 문자열을 작성하기 위해 필요한 최소 키 입력 횟수를 꼐산하여 배열로 반환하는 메서드

        @param targets : 작성해야 할 목표 문자열들이 담긴 배열
        @param map : 각 문자에 대해 최소 입력 횟수가 저장된 HashMap
        @return : 각 문자열을 작성하기 위한 최소 키 입력 횟수가 담긴 배열
     */
    private static int[] calculateKeyPresses(String[] targets, HashMap<Character, Integer> map) {
        // target 배열의 각 문자에 대해 필요한 키 입력 횟수를 저장할 크기만큼의 int 배열 생성
        int[] result = new int[targets.length];

        // targets 배열의 각 문자열을 순회
        for (int i = 0; i < targets.length; i++) {
            // 현재 문자열을 작성하기 위해 필요한 키 입력 횟수를 계산
            int pressCount = calculatePressCountForTarget(targets[i], map);
            // 계산된 키 입력 횟수를 결과 배열의 해당 위치에 저장
            result[i] = pressCount;
        }

        return result; // 결과값 (배열) 반환

    }


    /*
        주어진 target 문자열을 작성하기 위해 필요한 키 입력 횟수를 계산하는 메서드

        @param target : 작성해야 할 목표 문자열
        @param map : 각 문자에 대해 최소 입력 횟수가 저장된 HashMap
        @return : 목표 문자열을 작성하기 위해 필요한 키 입력 횟수, 작성할 수 없는 경우 -1을 반환
     */
    private static int calculatePressCountForTarget(String target, HashMap<Character, Integer> map) {
        // 필요한 키 입력 횟수를 누적할 변수
        int count = 0;

        // 목표 문자열의 각 문자를 순서대로 확인
        for (int j = 0; j < target.length(); j++) {
            // 현재 확인 중인 문자를 ch에 저장
            char ch = target.charAt(j);

            // map에 현재 문자가 존재하는지 확인
            if (map.containsKey(ch)) {
                // 문자가 존재하면, 해당 문자를 작성하는 데 필요한 키 입력 횟수를 누적
                count += map.get(ch);
            } else {
                // 문자가 존재하지 않으면 -1을 반환하여 해당 문자열을 작성할 수 없음을 표시
                return -1;
            }
        }

        // 모든 문자를 처리하여 계산된 총 키 입력 횟수 반환
        return count;
    }

}



