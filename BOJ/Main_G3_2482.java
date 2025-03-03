package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 색상환(https://www.acmicpc.net/problem/2482)
public class Main_G3_2482 {

    static int[][] dpTable;
    static int modulo = 1000000003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        dpTable = new int[N+1][K+1];

        for(int[] row : dpTable){
            Arrays.fill(row,-1);
        }

        //첫번째 점을 고름
        int answer1 = dp(N-3,K-1);

        //첫번째 점을 고르지 않음
        int answer2 = dp(N-1,K);

        bw.write((answer1 + answer2)%modulo + "");
        bw.flush();
    }

    public static int dp(int n, int k){
        if(n < 0){
            return 0;
        }

        if(dpTable[n][k] != -1){
            return dpTable[n][k];
        }

        if(k == 1){
            dpTable[n][k] = n % modulo;
            return dpTable[n][k];
        }

        if(k == 0){
            return 1;
        }

        int result = 0;

        result += dp(n-1,k) % modulo;
        result += dp(n-2,k-1) % modulo;

        dpTable[n][k] = result % modulo;

        return dpTable[n][k];
    }
}