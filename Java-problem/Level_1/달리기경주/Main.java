package 달리기경주;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] players =  {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = solution(players, callings);
        System.out.println(Arrays.toString(result));

    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerPositions = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            playerPositions.put(players[i], i);
        }

        for(String call : callings) {
            int pos = playerPositions.get(call);
            if(pos > 0) {
                String previousPlayer = players[pos - 1];
                players[pos - 1] = call;
                players[pos] = previousPlayer;

                // 위치 정보 업데이트
                playerPositions.put(call, pos - 1);
                playerPositions.put(previousPlayer, pos);

            }
        }
        return players;
    }
}
