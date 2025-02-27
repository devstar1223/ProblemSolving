package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 미로만들기(https://www.acmicpc.net/problem/2665)
public class Main_G4_2665 {

    static int[][] ground;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N, INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        ground = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = (br.readLine()).split("");
            for (int j = 0; j < N; j++) {
                ground[i][j] = Integer.parseInt(line[j]);
            }
        }

        bw.write(bfs() + "");
        bw.flush();
    }

    private static int bfs() {
        int[][] breakCount = new int[N][N];
        for(int[] row : breakCount){
            Arrays.fill(row,INF);
        }
        breakCount[0][0] = 0;

        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0,0});
        while(!deque.isEmpty()){
            int[] yx = deque.pollFirst();
            int y = yx[0];
            int x = yx[1];

            if(y == N-1 && x == N-1){
                return breakCount[N-1][N-1];
            }

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= 0 && nx >= 0 && ny < N && nx < N){
                    int newCost = breakCount[y][x] + (ground[ny][nx] == 1 ? 0 : 1);
                    if(newCost < breakCount[ny][nx]){
                        breakCount[ny][nx] = newCost;
                        if(ground[ny][nx] == 1){
                            deque.addFirst(new int[]{ny,nx});
                        }else{
                            deque.addLast(new int[]{ny,nx});
                        }
                    }
                }
            }
        }

        return -1;
    }


}