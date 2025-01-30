package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 내리막 길(https://www.acmicpc.net/problem/1520)
public class Main_G3_1520 {

    static int N, M;
    static int[] dy = new int[]{1,-1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int[][] ground,dpTable;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        ground = new int[N][M];
        dpTable = new int[N][M];

        for(int i = 0; i < N; i++){
            Arrays.fill(dpTable[i],-1);
        }

        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(line[j]);
            }
        }

        bw.write(dfs(0,0)+"");
        bw.flush();

    }

    private static int dfs(int r, int c){

        int result = 0;

        if(dpTable[r][c] != -1){
            return dpTable[r][c];
        }

        if(r == N -1 && c == M -1){
            return 1;
        }

        for(int i = 0; i < 4; i++){
            int ny = r + dy[i];
            int nx = c + dx[i];
            if(ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx] && ground[ny][nx] < ground[r][c]){
                visited[ny][nx] = true;
                result += dfs(ny,nx);
                visited[ny][nx] = false;
            }
        }

        dpTable[r][c] = result;

        return dpTable[r][c];
    }
}