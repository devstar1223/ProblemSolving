package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 오르막 수(https://www.acmicpc.net/problem/11057)
public class Main_S1_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dpTable = new long[N+1][10];
        Arrays.fill(dpTable[1],1);

        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                long result = 0;
                for(int k = 0; k <= j; k++){
                    result += dpTable[i-1][k];
                }
                dpTable[i][j] = result % 10007;
            }
        }

        long answer = 0;
        for(int i = 0; i < 10; i++){
            answer += dpTable[N][i];
        }
        answer %= 10007;
        bw.write(answer+"");
        bw.flush();
    }

}