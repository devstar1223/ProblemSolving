package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 겹치는 건 싫어(https://www.acmicpc.net/problem/20922)
public class Main_S1_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NK = (rd.readLine()).split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] stringArray = (rd.readLine()).split(" ");
        Map<String,Integer> numberCountMap = new HashMap<>();
        int start = 0;
        int answer = 0;
        int max = 0;
        for(int i = 0; i < N; i++){
            String s = stringArray[i];
            if(numberCountMap.get(s) == null || numberCountMap.get(s) < K){
                numberCountMap.put(s,numberCountMap.getOrDefault(s,0)+1);
                answer++;
                max = Math.max(answer,max);
            }
            else{
                String startString = stringArray[start];
                while(!startString.equals(s)){
                    numberCountMap.put(startString,numberCountMap.get(startString)-1);
                    start++;
                    answer--;
                    startString = stringArray[start];
                }
                start++;
            }
        }
        wr.write(max+"");
        wr.flush();
    }
}