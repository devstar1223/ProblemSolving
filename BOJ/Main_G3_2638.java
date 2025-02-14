package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 치즈(https://www.acmicpc.net/problem/2638)
public class Main_G3_2638 {

    static int[][] ground;
    static int N,M,cheeseCount;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        ground = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(line[j]);
                if (ground[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        int timeCount = 0;

        while(cheeseCount > 0){
            outsideCheckBfs(0,0);
            timeCount++;
            cheeseMelt();
        }

        bw.write(timeCount+"");
        bw.flush();
    }

    private static void outsideCheckBfs(int y, int x){
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        ground[y][x] = -1;
        q.add(new int[]{0,0});

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
               int[] yx = q.poll();
               int pollY = yx[0];
               int pollX = yx[1];
               for(int j = 0; j < 4; j++){
                   int ny = pollY + dy[j];
                   int nx = pollX + dx[j];
                   if(ny < 0 || nx < 0 || ny >= N || nx >= M){
                       continue;
                   }
                   if(!visited[ny][nx] && ground[ny][nx] != 1){
                       visited[ny][nx] = true;
                       ground[ny][nx] = -1;
                       q.add(new int[]{ny,nx});
                   }
               }
            }
        }

    }

    private static void cheeseMelt(){
        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < M-1; j++){
                if(ground[i][j] == 1){

                    int outside = 0;

                    for(int k = 0; k < 4; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ground[ny][nx] == -1){
                            outside++;
                        }
                    }

                    if(outside >= 2){
                        ground[i][j] = 0;
                        cheeseCount--;
                    }
                }
            }
        }
    }
}