package ProblemSolving.Programmers;
import java.util.*;

class Solution_LV1_150370 {

    public static HashMap<String, Integer> endDate = new HashMap<>();
    public static int todayDate;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        termsParsing(terms);
        todayDate = dateParsing(today);
        for(int i = 0; i < privacies.length; i++){
            if(isDelete(privacies[i])){
                System.out.println(answerList.add(i+1));
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void termsParsing(String[] terms){
        for(String s : terms){
            String term = String.valueOf(s.charAt(0));
            Integer date = Integer.parseInt(s.substring(2)) * 28;
            endDate.put(term,date);
        }
    }

    public static int dateParsing(String s){
        int years = Integer.parseInt(s.substring(0,4)) * 336;
        int months = (Integer.parseInt(s.substring(5,7)) - 1) * 28;
        int days = Integer.parseInt(s.substring(8,10));

        return years+months+days;
    }

    public static boolean isDelete(String s){
        String term = s.substring(11);
        int deleteDate = dateParsing(s) + endDate.get(term);
        if(deleteDate <= todayDate){
            System.out.println(deleteDate);
            System.out.println(todayDate);
            return true;
        }
        return false;
    }

}