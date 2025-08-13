package ProblemSolving.BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 쉬운 최단거리 (https://www.acmicpc.net/problem/14940)
public class Main_S1_14940 {

    public static int[][] ground;
    public static int[][] answerBoard;
    public static int N,M;
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        int[] startYX = new int[2];
        ground = new int[N][M];
        answerBoard = new int[N][M];

        for(int[] array : answerBoard){
            Arrays.fill(array,-1);
        }

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(line[j]);
                if(ground[i][j] == 2){
                    startYX[0] = i;
                    startYX[1] = j;
                }else if(ground[i][j] == 0){
                    answerBoard[i][j] = 0;
                }
            }
        }

        // solve
        bfs(startYX);

        // output
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(answerBoard[i][j]+"");
                if(j != M-1){
                    bw.write(" ");
                }
            }
            if(i != N-1){
                bw.newLine();
            }
        }

        bw.flush();
    }

    private static void bfs(int[] startYX){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(startYX);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int currentY = q.peek()[0];
                int currentX = q.poll()[1];
                answerBoard[currentY][currentX] = count;

                for(int j = 0; j < 4; j++){
                    int ny = currentY + dy[j];
                    int nx = currentX + dx[j];
                    if(ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx] && ground[ny][nx] == 1){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                    }
                }
            }
            count++;
        }
    }
}

