package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV2_42746 {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int i : numbers){
            list.add(String.valueOf(i));
        }
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }
        String answer = sb.toString();

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}