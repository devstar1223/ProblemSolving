package ProblemSolving.BOJ;

import java.io.*;

// 공통 부분 문자열(https://www.acmicpc.net/problem/5582)
public class Main_G5_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] stringM = (br.readLine()).split("");
        String[] stringN = (br.readLine()).split("");
        int N = stringN.length;
        int M = stringM.length;
        int[][] dp = new int[N+1][M+1];
        boolean[][] equalCheck = new boolean[N+1][M+1];
        int answer = 0;
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                if(stringM[j-1].equals(stringN[i-1])){
                    equalCheck[i][j] = true;
                    if(equalCheck[i-1][j-1]){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else if(dp[i-1][j-1] == 0){
                        dp[i][j] = 1;
                    }
                    answer = Math.max(dp[i][j],answer);
                }
            }
        }

        bw.write(answer+"");
        bw.flush();
    }
}