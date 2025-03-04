package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 연구소(https://www.acmicpc.net/problem/14502)
public class Main_G4_14502 {

    static int[][] ground;
    static int N,M,safeZone;
    static List<int[]> startPointList = new ArrayList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        ground = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] row = (br.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(row[j]);
                if(ground[i][j] == 2){
                    startPointList.add(new int[]{i,j});
                }
            }
        }

        install(0);

        bw.write(safeZone+"");
        bw.flush();
    }

    private static void install(int count){
        if(count == 3){
            virusDiffuse(ground);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(ground[i][j] == 0){
                    ground[i][j] = 1;
                    install(count+1);
                    ground[i][j] = 0;
                }
            }
        }
    }

    private static void virusDiffuse(int[][] ground){
        int[][] simulationGround = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                simulationGround[i][j] = ground[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for(int[] indexArray : startPointList){
            q.add(indexArray);
        }

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int y = q.peek()[0];
                int x = q.poll()[1];

                for(int j = 0; j < 4; j++){
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if(ny >= 0 && nx >= 0 && ny < N && nx < M && simulationGround[ny][nx] == 0){
                        q.add(new int[]{ny,nx});
                        simulationGround[ny][nx] = 1;
                    }
                }
            }
        }

        safeZone = Math.max(safeZone,safeZoneCount(simulationGround));
    }

    private static int safeZoneCount(int[][] ground){
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(ground[i][j] == 0){
                    result++;
                }
            }
        }
        return result;
    }
}