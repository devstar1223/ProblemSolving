package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//20728. 공평한 분배 2
public class Solution_D3_20728 {
    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(rd.readLine());
        for(int tc = 1; tc <= T; tc++) {
            String[] tmp = (rd.readLine()).split(" ");
            int N = Integer.parseInt(tmp[0]);
            int K = Integer.parseInt(tmp[1]);
            String[] candyArray = (rd.readLine()).split(" ");
            List<Integer> candyList = new ArrayList<>();
            for(String s : candyArray){
                candyList.add(Integer.parseInt(s));
            }
            Collections.sort(candyList);

            int answer = Integer.MAX_VALUE;

            if(N == K){
                answer = candyList.get(N-1) - candyList.get(0);
            } else{
                for(int i = 0; i < N-K+1; i++){
                    answer = Math.min(answer, candyList.get(i+K-1) - candyList.get(i));
                }
            }

            wr.write("#"+tc+" "+answer);

            if(tc != T){
                wr.newLine();
            }
        }
        wr.flush();
        rd.close();
        wr.close();
    }
}