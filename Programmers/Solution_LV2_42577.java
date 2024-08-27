package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV2_42577 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        for(String s : phone_book){
            set.add(s);
        }

        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                String head = phone_book[i].substring(0,j);
                if(set.contains(head)){
                    System.out.println(head);
                    return false;
                }
            }
        }

        return true;
    }
}