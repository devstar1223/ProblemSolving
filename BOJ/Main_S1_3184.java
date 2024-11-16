package ProblemSolving.BOJ;

import java.io.*;

// 양(https://www.acmicpc.net/problem/3184)
public class Main_S1_3184 {

    public static String[][] ground;
    public static boolean[][] visit;
    public static int[] dy = {1,-1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] RC = (rd.readLine()).split(" ");
        int R = Integer.parseInt(RC[0]);
        int C = Integer.parseInt(RC[1]);
        ground = new String[R][C];
        visit = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String[] tmp = (rd.readLine()).split("");
            for(int j = 0; j < C; j++){
                String value = tmp[j];
                ground[i][j] = value;
                if(value.equals("#")){
                    visit[i][j] = true;
                }
            }
        }

        int sheep = 0;
        int wolf = 0;

        // solve

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visit[i][j]){
                    int[] result = dfs(i,j,new int[]{0,0});
                    if(result[0] > result[1]){
                        sheep += result[0];
                    }
                    else{
                        wolf += result[1];
                    }
                }
            }
        }

        // out
        wr.write(sheep +" "+wolf);
        wr.flush();
    }

    public static int[] dfs(int r, int c, int[] ov){
        visit[r][c] = true;

        if(ground[r][c].equals("o")){
            ov[0]++;
        }
        else if(ground[r][c].equals("v")){
            ov[1]++;
        }

        for(int i = 0; i < 4; i++){
            int ny = r + dy[i];
            int nx = c + dx[i];
            if(ny >= 0 && nx >= 0 && ny < ground.length && nx < ground[0].length && !visit[ny][nx]){
                dfs(ny,nx,ov);
            }
        }
        return ov;
    }

}