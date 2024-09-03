package ProblemSolving.BOJ;

import java.util.*;

// 평범한 배낭(https://www.acmicpc.net/problem/12865)
public class Main_G5_12865 {

    public static int[] W;
    public static int[] V;
    public static int[][] dpTable;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp1 = (sc.nextLine()).split(" ");
        int N = Integer.parseInt(tmp1[0]);
        int K = Integer.parseInt(tmp1[1]);
        W = new int[N+1];
        V = new int[N+1];
        dpTable = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dpTable[i][j] = -1;
            }
        }
        for(int i = 1; i < N+1; i++){
            String[] tmp2 = (sc.nextLine()).split(" ");
            W[i] = Integer.parseInt(tmp2[0]);
            V[i] = Integer.parseInt(tmp2[1]);
        }
        solve(N,K);
        System.out.println(dpTable[N][K]);
    }
    public static int solve(int n, int k){
        if(n == 0){
            return 0;
        }
        if(dpTable[n][k] != -1){
            return dpTable[n][k];
        }
        int case1 = 0;
        if(k - W[n] >= 0){
            case1 = solve(n-1, k - W[n]) + V[n];
        }
        int case2 = solve(n-1, k);

        dpTable[n][k] = Math.max(case1,case2);

        return dpTable[n][k];
    }

}