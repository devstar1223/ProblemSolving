package ProblemSolving.BOJ;

import java.io.*;

// 욕심쟁이 판다(https://www.acmicpc.net/problem/1937)
public class Main_G3_1937 {

    static int N,answer = -1;
    static int[][] ground,DP;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        ground = new int[N][N];
        DP = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split(" ");
            for(int j = 0; j < N; j++){
                ground[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                answer = Math.max(answer,dfs(i,j));
            }
        }
        bw.write(answer+"");
        bw.flush();
    }

    private static int dfs(int y, int x){
        int base = 1;
        int add = 0;

        if(DP[y][x] != 0){
            return DP[y][x];
        }

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && nx >= 0 && ny < N && nx < N && ground[ny][nx] > ground[y][x]){
                add = Math.max(add,dfs(ny,nx));
            }
        }

        DP[y][x] = base + add;

        return DP[y][x];
    }
}