package src;

import java.util.Arrays;

public class ParkWalk {
    public static void main(String[] args) {
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        int[] result = solution(park, routes);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] park, String[] routes) {

        int rows = park.length;
        int cols = park[0].length();
        int x = 0;
        int y = 0;

        // 시작 위치 (S) 찾기
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        // 명령 처리
        for(String route : routes) {
            String[] splitRoute = route.split(" ");
            String direction = splitRoute[0];
            int distance = Integer.parseInt(splitRoute[1]);

            int dx = 0;
            int dy = 0;

            switch(direction) {
                case "E":
                    dy = 1;
                    break;
                case "S":
                    dx = 1;
                    break;
                case "W":
                    dy = -1;
                    break;
                case "N":
                    dx = -1;
                    break;
            }

            // 목표 지점 계산
            int nx = x + dx * distance;
            int ny = y + dy * distance;

            // 유효한 이동인지 확인
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                boolean isValidMove = true;

                // 이동 경로 중 장애물 확인
                for (int i = 1; i <= distance; i++) {
                    int checkX = x + dx * i;
                    int checkY = y + dy * i;

                    if (park[checkX].charAt(checkY) == 'X') {
                        isValidMove = false;
                        break;
                    }
                }

                // 유효한 경우에만 위치 업데이트
                if (isValidMove) {
                    x = nx;
                    y = ny;
                }
            }
        }


        int[] answer = {x, y};
        return answer;
    }
}