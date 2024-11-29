package ProblemSolving.BOJ;

import java.io.*;

// N-Queen(https://www.acmicpc.net/problem/9663)
public class Main_G4_9663 {

    public static int N;
    public static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(rd.readLine());
        int answer = 0;
        ground = new int[N][N];
        for(int i = 0; i < N; i++){
            answer += nQueen(0,i);
        }
        wr.write(answer+"");
        wr.flush();

    }

    public static int nQueen(int r, int c) {
        int answer = 0;
        if(ground[r][c] != 0){
            return 0;
        }
        if(r == N-1){
            return 1;
        }
        checkDown(r,c,1);
        for(int i = 0; i < N; i++){
            answer += nQueen(r+1,i);
        }
        checkDown(r,c,-1);

        return answer;
    }

    public static void checkDown(int r, int c, int delta) { // 가로 / 세로(아래) / 대각선(아래)
        ground[r][c] += delta; // 현재 위치

        for(int i = c+1; i < N; i++){ // 가로 우측
            ground[r][i] += delta;
        }
        for(int i = c-1; i >= 0; i--){ // 가로 좌측
            ground[r][i] += delta;
        }
        for(int i = r+1; i < N; i++){ // 세로 아래
            ground[i][c] += delta;
        }
        int maxLoop1 = N - Math.max(r,c);
        for(int i = 1; i < maxLoop1; i++){ // 우하단 대각선
            ground[r+i][c+i] += delta;
        }
        int maxLoop2 = Math.min(N-r,c+1);
        for(int i = 1; i < maxLoop2; i++){ // 좌하단 대각선
            ground[r+i][c-i] += delta;
        }
    }
}