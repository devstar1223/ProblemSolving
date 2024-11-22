package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 데스 나이트(https://www.acmicpc.net/problem/16948)
public class Main_S1_16948 {

    public static int[] dr = new int[]{-2,-2,0,0,2,2};
    public static int[] dc = new int[]{-1,1,-2,2,-1,1};
    public static int[][] ground;
    public static boolean[][] visit;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        N = Integer.parseInt(rd.readLine());
        String[] rc = (rd.readLine()).split(" ");
        int r1 = Integer.parseInt(rc[0]);
        int c1 = Integer.parseInt(rc[1]);
        int r2 = Integer.parseInt(rc[2]);
        int c2 = Integer.parseInt(rc[3]);

        ground = new int[N][N];
        visit = new boolean[N][N];
        // solve

        wr.write(bfs(r1,c1,r2,c2)+"");

        // out
        wr.flush();
    }

    public static int bfs(int r1, int c1, int r2, int c2){
        Queue<int[]> q = new LinkedList<>();
        visit[r1][c1] = true;
        q.add(new int[]{r1,c1});
        int count = 0;
        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int r = q.peek()[0];
                int c = q.poll()[1];

                if(r == r2 && c == c2){
                    return count;
                }

                for(int j = 0; j < 6; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]){
                        visit[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }

            }

            count++;
        }

        return -1;
    }
}