package ProblemSolving.Programmers;

//뉴스 클러스터링 (https://school.programmers.co.kr/learn/courses/30/lessons/17677)

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> A = makeTwoLengthWordList(str1);
        List<String> B = makeTwoLengthWordList(str2);
        double totalSum = (A.size() + B.size()); // 총합 (합집합 X)
        double inter = intersection(A,B); // 교집합
        double union = totalSum - inter;
        if(totalSum == 0){
            return 65536;
        }
        int answer = (int) ((inter / union) * 65536);
        return answer;
    }
    public static List<String> makeTwoLengthWordList(String str){
        str = str.toLowerCase();
        List<String> twoLengthWordList = new ArrayList<>();

        for(int i = 0; i < str.length()-1; i++){
            twoLengthWordList.add(String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+1)));
        }

        List<String> finalList = new ArrayList<>();

        for(String s : twoLengthWordList){
            Character c1 = s.charAt(0);
            Character c2 = s.charAt(1);
            if(isAlphabet(c1) && isAlphabet(c2)){
                finalList.add(s);
            }
        }
        Collections.sort(finalList);
        return finalList;
    }

    public static boolean isAlphabet(char c){
        return 0 <= (c - 'a') && (c - 'a') < 26;
    }

    public static double intersection(List<String> A, List<String> B){
        double interValue = 0;
        HashMap<String, Integer> mapA = new HashMap<>();
        for(String s : A){
            mapA.put(s, mapA.getOrDefault(s, 0) + 1);
        }
        for(String s : B){
            if(mapA.get(s) != null){
                interValue++;
                if(mapA.get(s) == 1){
                    mapA.remove(s);
                }
                else{
                    mapA.put(s,mapA.get(s)-1);
                }
            }
        }
        return interValue;
    }

}

