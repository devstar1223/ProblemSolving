package ProblemSolving.BOJ;

import java.util.Scanner;

// 내려가기(https://www.acmicpc.net/problem/2096)
public class Main_G5_2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] ground = new int[N][3];
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];
        sc.nextLine();
        for(int i = 0; i < N; i++){
            String[] tmp = (sc.nextLine()).split(" ");
            for(int j = 0; j < 3; j++){
                ground[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        for(int i = 0; i < 3; i++){
            dpMax[0][i] = ground[0][i];
            dpMin[0][i] = ground[0][i];
        }

        for(int i = 1; i < N; i++){
            dpMax[i][0] = ground[i][0] + Math.max(dpMax[i-1][0],dpMax[i-1][1]);
            dpMax[i][1] = ground[i][1] + Math.max(Math.max(dpMax[i-1][0],dpMax[i-1][1]),dpMax[i-1][2]);
            dpMax[i][2] = ground[i][2] + Math.max(dpMax[i-1][1],dpMax[i-1][2]);

            dpMin[i][0] = ground[i][0] + Math.min(dpMin[i-1][0],dpMin[i-1][1]);
            dpMin[i][1] = ground[i][1] + Math.min(Math.min(dpMin[i-1][0],dpMin[i-1][1]),dpMin[i-1][2]);
            dpMin[i][2] = ground[i][2] + Math.min(dpMin[i-1][1],dpMin[i-1][2]);
        }
        int answerMax = Math.max(Math.max(dpMax[N-1][0],dpMax[N-1][1]),dpMax[N-1][2]);
        int answerMin = Math.min(Math.min(dpMin[N-1][0],dpMin[N-1][1]),dpMin[N-1][2]);

        System.out.println(answerMax + " " + answerMin);

    }
}