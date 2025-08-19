package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 단디번호붙이기 (https://www.acmicpc.net/problem/2667)
public class Main_S1_2667 {

    public static int[][] ground;
    public static boolean[][] visited;
    public static int[] dr = {-1,1,0,0};
    public static int[] dc = {0,0,-1,1};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        N = Integer.parseInt(br.readLine());
        ground = new int[N][N];
        visited = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            String[] line = br.readLine().split("");
            for (int c = 0; c < N; c++) {
                ground[r][c] = Integer.parseInt(line[c]);
            }
        }

        List<Integer> answerList = new ArrayList<>();

        // solve
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(!visited[r][c] && ground[r][c] == 1){
                    answerList.add(dfs(r,c));
                }
            }
        }

        // output
        Collections.sort(answerList);
        int len = answerList.size();
        bw.write(len+"\n");
        for (int i = 0; i < len; i++) {
            bw.write(answerList.get(i) + "");
            if (i != len - 1) {
                bw.newLine();
            }
        }
        bw.flush();
    }

    private static int bfs(int r, int c){
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int currentR = q.peek()[0];
                int currentC = q.poll()[1];
                result++;

                for(int j = 0; j < 4; j++){
                    int nr = currentR + dr[j];
                    int nc = currentC + dc[j];
                    if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && ground[nr][nc] == 1){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return result;
    }

    private static int dfs(int r, int c){
        visited[r][c] = true;
        int result = 1;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && ground[nr][nc] == 1){
                result += dfs(nr,nc);
            }
        }

        return result;
    }
}

