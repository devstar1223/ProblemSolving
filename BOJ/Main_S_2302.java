package ProblemSolving.BOJ;

import java.io.*;

// 극장 좌석(https://www.acmicpc.net/problem/2302)
public class Main_S_2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(rd.readLine());
        boolean[] vipSeat = new boolean[N+1];
        int M = Integer.parseInt(rd.readLine());
        for(int i = 0; i < M; i++){
            int seatNum = Integer.parseInt(rd.readLine());
            vipSeat[seatNum] = true;
        }
        // solve
        int start = -1;
        int answer = 1;

        int[] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        for(int i = 1; i <= N; i++){
            if(start == -1 && !vipSeat[i]){
                start = i;
            }else if(start != -1 && vipSeat[i]){
                answer *= dp[i - start];
                start = -1;
            }else if(start != -1 && i == N){
                answer *= dp[i+1 - start];
            }
        }

        // out
        wr.write(answer+"");
        wr.flush();
    }
}