package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BackgroundClear {
    public static void main(String[] args) {
        String[] wallpaper = {
                "..........",
                ".....#....",
                "......##..",
                "...##.....",
                "....#....."
        };

        // solution 함수 호출 및 결과 저장
        int[] result = solution(wallpaper);
        System.out.println(Arrays.toString(result));

    }

    public static int[] solution(String[] wallpaper) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        int arr[];

        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        arr = new int[]{Collections.min(row), Collections.min(col), Collections.max(row) + 1, Collections.max(col) + 1};
        return arr;
    }
}