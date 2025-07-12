package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV2_60057 {
    public int solution(String s) {
        int count = 0;
        int answer = s.length();

        Stack<String> stack = new Stack<>();

        int maxMinusValue = 0;

        for(int i = 1; i <= s.length()/2; i++){
            maxMinusValue = Math.max(calcul(s,i),maxMinusValue);
        }

        return s.length() - maxMinusValue;
    }

    public static int calcul(String s, int divideAmount){

        int totalMinus = 0;
        int count = 1;

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i += divideAmount){

            String divideString = "";

            int left = i;
            int right = i + divideAmount;

            if(right > s.length()){
                divideString = s.substring(left);
            }else{
                divideString = s.substring(left,right);
            }

            if(stack.isEmpty()){
                stack.push(divideString);
            }
            else if(stack.peek().equals(divideString)){
                totalMinus += divideString.length();
                count += 1;
            }else{
                stack.push(divideString);
                if(count >= 2){
                    totalMinus -= (String.valueOf(count)).length();
                }
                count = 1;
            }

        }

        if(count > 1){
            totalMinus -= (String.valueOf(count)).length();
        }

        return totalMinus;
    }
}
