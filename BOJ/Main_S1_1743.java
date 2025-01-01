package ProblemSolving.BOJ;

import java.io.*;

// 음식물 피하기(https://www.acmicpc.net/problem/1743)
public class Main_S1_1743 {

    public static boolean[][] ground,visit;
    public static int[] DY = {-1,1,0,0};
    public static int[] DX = {0,0,-1,1};
    public static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NMK = (br.readLine()).split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        int K = Integer.parseInt(NMK[2]);

        ground = new boolean[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int i = 0; i < K; i++){
            String[] RC = (br.readLine()).split(" ");
            int R = Integer.parseInt(RC[0]);
            int C = Integer.parseInt(RC[1]);
            ground[R][C] = true;
        }

        int answer = 0;

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                if(ground[i][j] && !visit[i][j]){
                    answer = Math.max(answer,dfs(i,j));
                }
            }
        }
        bw.write(answer+"");
        bw.flush();
    }

    private static int dfs(int y, int x){
        int result = 1;

        visit[y][x] = true;

        for(int i = 0; i < 4; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(ny > 0 && nx > 0 && ny <= N && nx <= M && ground[ny][nx] &&!visit[ny][nx]){
                result += dfs(ny,nx);
            }
        }

        return result;
    }
}