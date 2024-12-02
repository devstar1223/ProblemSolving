package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 전깃줄(https://www.acmicpc.net/problem/2565)
public class Main_G5_2565 {

    public static int[][] abArray;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        int[][] lineAB = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] AB = (rd.readLine()).split(" ");
            lineAB[i][0] = Integer.parseInt(AB[0]);
            lineAB[i][1] = Integer.parseInt(AB[1]);
        }

        Arrays.sort(lineAB,(a,b) -> Integer.compare(a[0],b[0]));

        int[] dp = new int[N];
        dp[0] = 1;
        int answer = 0;
        for(int i = 1; i < N; i++){
            if(lineAB[i][1] > lineAB[i-1][1]){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }
            for(int j = i; j >= 0; j--){
                if(dp[j] >= dp[i] && lineAB[j][1] < lineAB[i][1]){
                    dp[i] = dp[j]+1;
                }
            }
            answer = Math.max(answer,dp[i]);
        }

        wr.write(N-answer+"");
        wr.flush();
    }

}