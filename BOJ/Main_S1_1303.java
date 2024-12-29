package ProblemSolving.BOJ;

import java.io.*;

// 전쟁 - 전투(https://www.acmicpc.net/problem/1303)
public class Main_S1_1303 {

    public static int N,M;
    public static boolean[][] visit;
    public static String[][] ground;
    public static int[] DY = {-1,1,0,0};
    public static int[] DX = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[1]);
        M = Integer.parseInt(NM[0]);
        ground = new String[N][M];
        visit = new boolean[N][M];
        int[] answer = new int[2];
        for(int i = 0; i < N; i++){
            String[] tmp = (br.readLine()).split("");
            for(int j = 0; j < M; j++){
                ground[i][j] = tmp[j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visit[i][j]){
                    double power = Math.pow(dfs(i,j,ground[i][j]),2);
                    if(ground[i][j].equals("W")){
                        answer[0] += power;
                    }
                    else{
                        answer[1] += power;
                    }
                }
            }
        }

        bw.write(answer[0]+" "+answer[1]);
        bw.flush();
    }


    private static int dfs(int y, int x, String color){
        visit[y][x] = true;
        int result = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(ny >= 0 && nx >= 0 && ny < N && nx < M && !visit[ny][nx] && ground[ny][nx].equals(color)){
                result += dfs(ny,nx,color);
            }
        }
        return result;
    }
}
