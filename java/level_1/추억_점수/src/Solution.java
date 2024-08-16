package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };
        int[] result = solution(name, yearning, photo);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> arr1 = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            arr1.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++) {
            for(int j = 0; j < photo[i].length; j++) {
                answer[i] += arr1.getOrDefault(photo[i][j], 0);
            }
        }

        return answer;
    }
}
