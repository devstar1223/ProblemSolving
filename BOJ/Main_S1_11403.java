package ProblemSolving.BOJ;

import java.util.*;
// 경로 찾기(https://www.acmicpc.net/problem/11403)
public class Main_S1_11403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] answer = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] tmp = (sc.nextLine()).split(" ");
            for(int j = 0; j < N; j++){
                answer[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(answer[i][k] == 1 && answer[k][j] == 1) {
                        answer[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(answer[i][j]);
                if(j < N-1){
                    System.out.print(" ");
                }
            }
            if(i < N-1){
                System.out.println();
            }
        }
    }
}