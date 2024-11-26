package ProblemSolving.BOJ;

import java.io.*;

// 1, 2, 3 더하기 7(https://www.acmicpc.net/problem/15992)
public class Main_15992 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(rd.readLine());

        long[][] dp = new long[1001][1001];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for(int i = 4; i < 1001; i++){
            for(int j = 2; j <= i; j++){
                dp[i][j] = (dp[i-3][j-1] + dp[i-2][j-1] + dp[i-1][j-1]) % 1000000009;
            }
        }

        for(int i = 0; i < T; i++){
            String[] nm = (rd.readLine()).split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            wr.write(dp[n][m]+"");
            if(i != T-1){
                wr.newLine();
            }
            wr.flush();
        }
    }

}