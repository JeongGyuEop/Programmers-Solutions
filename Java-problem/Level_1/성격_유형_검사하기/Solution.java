package 성격_유형_검사하기;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {

		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		String result = solution(survey, choices);
		
		System.out.println(result);

	}
	
	public static String solution(String[] survey, int[] choices) {
        
        String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};
        
        HashMap<Integer, Integer> mapScore = new HashMap<Integer, Integer>();
        HashMap<String, Integer> mapResult = new HashMap<String, Integer>();
        
        for(int i=1; i<8; i++) {
        	int val = Math.abs(4-i);
        	mapScore.put(i, val);
        }
        
        for(int i=0; i<type.length; i++) {
        	mapResult.put(type[i], 0);
        }
        
        for(int i=0; i<survey.length; i++) {
        	String[] arr = survey[i].split("");
        	if(choices[i] < 4) {
        		mapResult.put(arr[0], mapResult.get(arr[0]) + mapScore.get(choices[i]));
        	} else  if (choices[i] > 4){
        		mapResult.put(arr[1], mapResult.get(arr[1]) + mapScore.get(choices[i]));
        	}
        }
        
       StringBuilder result = new StringBuilder();
       result.append(mapResult.get("R") >= mapResult.get("T") ? "R" : "T");
       result.append(mapResult.get("C") >= mapResult.get("F") ? "C" : "F");
       result.append(mapResult.get("J") >= mapResult.get("M") ? "J" : "M");
       result.append(mapResult.get("A") >= mapResult.get("N") ? "A" : "N");
        
        
        return result.toString();
    }

}
