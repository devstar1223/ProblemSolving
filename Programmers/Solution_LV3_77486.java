package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV3_77486 {
    public static HashMap<String, String> parentInfo = new HashMap<>();
    public static HashMap<String, Integer> moneyInfo = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parentInfo = new HashMap<>();
        moneyInfo = new HashMap<>();

        for(int i = 0; i < enroll.length; i++){
            parentInfo.put(enroll[i],referral[i]);
            moneyInfo.put(enroll[i],0);
        }

        for(int i = 0; i < seller.length; i++){
            int getMoney = amount[i] * 100;
            int myMoney = (getMoney / 10) * 9;
            int payMoney = getMoney - myMoney;
            moneyInfo.put(seller[i],moneyInfo.get(seller[i])+myMoney);
            if(!(parentInfo.get(seller[i])).equals("-")){
                payMoneyToParent(parentInfo.get(seller[i]),payMoney);
            }
        }

        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = moneyInfo.get(enroll[i]);
        }
        return answer;
    }

    public static void payMoneyToParent(String parent,int distribution){
        int payMoney = (int)((double)distribution * 0.1);
        int myMoney = distribution - payMoney;

        if(distribution < 10){
            moneyInfo.put(parent,moneyInfo.get(parent)+myMoney);
            return;
        }

        if(parentInfo.get(parent).equals("-")){
            moneyInfo.put(parent,moneyInfo.get(parent)+myMoney);
            return;
        }
        moneyInfo.put(parent,moneyInfo.get(parent)+myMoney);
        payMoneyToParent(parentInfo.get(parent),payMoney);
    }
}
