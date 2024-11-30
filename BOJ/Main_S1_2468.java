package ProblemSolving.BOJ;

import java.io.*;

// 안전 영역(https://www.acmicpc.net/problem/2468)
public class Main_S1_2468 {

    public static int[][] ground;
    public static int[] dy = new int[]{1,-1,0,0};
    public static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(rd.readLine());
        ground = new int[N][N];
        for(int r = 0; r < N; r++){
            String[] tmp = (rd.readLine()).split(" ");
            for(int c = 0; c < N; c++){
                ground[r][c] = Integer.parseInt(tmp[c]);
            }
        }

        // solve
        int maxSafe = 0;
        for(int rain = 0; rain <= 100; rain++){
            boolean[][] visit = new boolean[N][N];
            int safe = 0;
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    if(!visit[r][c] && ground[r][c] > rain){
                        dfs(r, c, rain, visit);
                        safe++;
                    }
                }
            }
            maxSafe = Math.max(safe,maxSafe);
        }

        // out
        wr.write(maxSafe+"");
        wr.flush();
    }

    public static void dfs(int r, int c,int rain, boolean[][] visit){
        visit[r][c] = true;

        for(int i = 0; i < 4; i++){
            int ny = r + dy[i];
            int nx = c + dx[i];
            if(ny < visit.length && nx < visit[0].length && ny >= 0 && nx >= 0 && !visit[ny][nx] && ground[ny][nx] > rain){
                dfs(ny,nx,rain,visit);
            }
        }
    }


}