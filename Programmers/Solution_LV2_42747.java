package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV2_42747 {
    public int solution(int[] citations) {
        int cutline = citations.length;
        int pass = 0;
        Integer[] array = new Integer[cutline];
        for(int i = 0; i < cutline; i++){
            array[i] = citations[i];
        }
        Arrays.sort(array,Collections.reverseOrder());
        for(Integer i : array){
            if(i < cutline){
                if(i > pass){
                    cutline = i;
                    pass++;
                }
            }
            else{
                pass++;
            }
        }
        return pass;
    }
}